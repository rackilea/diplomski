package com.example.fdai3744.neueleereapp;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


    public class MainActivity extends AppCompatActivity {

        public Button button_1;
        public TextView text1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

          button_1 = (Button) findViewById(R.id.button1); //Button
           text1 = (TextView)findViewById(R.id.text1); // Textview

            button_1.setOnClickListener(new View.OnClickListener() { // Here I add the ActionListener for my button

                @Override
                public void onClick(View v) {
                    text1.setText("Button 1 wurde geklickt!");
                }
            });
        }

    }