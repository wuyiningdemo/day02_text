package com.bw.rikao0509.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.rikao0509.R;
import com.bw.rikao0509.bean.NewsBean;
import com.bw.rikao0509.persenter.IMain;
import com.bw.rikao0509.persenter.MainPersenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMain{

    @BindView(R.id.recy_view)
    RecyclerView recyView;
    private MainPersenter mainPersenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

    }
    public  void  initView(){
        mainPersenter = new MainPersenter(this);
        String key="f04ad16366c2c564e2669df6b5c70a40";
        int num=10;
        mainPersenter.getNews(key,num);
    }

    @Override
    public void onScuess(NewsBean newsBean) {

        MyAdapter myAdapter=new MyAdapter(MainActivity.this,newsBean);
        recyView.setAdapter(myAdapter);
        recyView.setLayoutManager(new LinearLayoutManager(this));
    }
}
