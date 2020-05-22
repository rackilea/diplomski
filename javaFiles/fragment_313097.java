package com.example.opnanotherlistexample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends Activity {
    private ListView listAnother;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        listAnother = (ListView) findViewById(R.id.listAnother);
        if (getIntent().hasExtra("parameters")) {
            String[] params = getIntent().getStringArrayExtra("parameters");
            arraylist = new ArrayList<String>();
            for (int i = 0; i < params.length; i++) {
                arraylist.add(params[i]);
                Log.e("balvier", params[i]);
            }
            adapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_dropdown_item_1line, arraylist);
            listAnother.setAdapter(adapter);
        }
    }

}