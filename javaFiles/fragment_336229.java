package com.example.test;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity  {

    Button b1;
    Button b2; 

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         b1 = (Button) findViewById(R.id.btn1);
         b2 = (Button) findViewById(R.id.btn2);
    }


    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn1:
                b2.setVisibility(View.VISIBLE);
                b1.setVisibility(View.INVISIBLE);
           break;
            case R.id.btn2:
                b2.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.VISIBLE);
           break;

        }
     }
  }