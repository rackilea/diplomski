package com.example.opnanotherlistexample;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
    String[] bodyPart = { "Chest", "Legs" };

    String[] chestsWorkout = { "Bench", "Pushups", "Pullups", "Incline bench",
            "Decline bench" };
    String[] legsWorkout = { "walk", "run"};

    private ListView listNew;
    private ArrayList<String> newarraylist;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listNew = (ListView) findViewById(R.id.listNew);
        newarraylist = new ArrayList<String>();
        for (int i = 0; i < bodyPart.length; i++) {
            newarraylist.add(bodyPart[i]);
        }
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line, newarraylist);
        listNew.setAdapter(adapter);
        listNew.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                    int position, long id) {
                // TODO Auto-generated method stub
                String clickedItem = newarraylist.get(position).toString();
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                if(clickedItem.toLowerCase().equals("chest")){
                    intent.putExtra("parameters", chestsWorkout);
                }else if(clickedItem.toLowerCase().equals("legs")){
                    intent.putExtra("parameters", legsWorkout);
                }
                startActivity(intent);

            }
        });
    }

}