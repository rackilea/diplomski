package com.mytest.ndktest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

TextView _tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _tvResult = (TextView)findViewById(R.id.tvResult);
    } 

    public void bGo_Click(View view) {

        long time = System.currentTimeMillis();
        FrequencySample.buildJ(1000, 22050, 8192);
        time = System.currentTimeMillis() - time;
        _tvResult.append( String.format("\n(%dms)",time));

        time = System.currentTimeMillis();
        FrequencySample.buildN(1000, 22050, 8192);
        time = System.currentTimeMillis() - time;
        _tvResult.append(String.format("\n(%dms)", time));

    }
}