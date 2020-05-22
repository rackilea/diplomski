package com.example.myfirstapplication;

 import android.view.View;
 import android.widget.Button;
 import android.widget.TextView;
 import android.os.Bundle;
 import android.app.Activity;

 public class MainActivity extends Activity{

      int counter;
      Button add, sub;
      TextView display;
      @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);   
           setContentView(R.layout.activity_main);
          counter = 0;
          add = (Button) findViewById(R.id.bAddOne);
          sub = (Button) findViewById(R.id.bSubOne);
          display = (TextView) findViewById(R.id.tvDisplay);
          add.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                       counter++;
                       display.setText("Your total is " + counter);
                    }
               });
          sub.setOnClickListener(new View.OnClickListener() {

                   public void onClick(View v) {
                           counter--;
                            display.setText("Your total is " + counter);
                   }
         });
     }
}