package com.demuro1.views;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    final Button aBut = (Button)findViewById(R.id.btn1);
    Button bBut = (Button)findViewById(R.id.btn2);
    final TextView aText = (TextView)findViewById(R.id.txtVw1);
    final TextView bText = (TextView)findViewById(R.id.txtVw2);

    aBut.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            aText.setText("You Clicked Button 1");

        }
    });

    bBut.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            bText.setText("You Clicked Button 2");

        }
    });
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

   }