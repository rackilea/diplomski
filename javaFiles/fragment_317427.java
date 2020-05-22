package com.example.drywallcalculator102v;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class FirstActivity extends Activity {

   private EditText editText;
   private Button btnNext;

   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.layout_firstactivity);

       btnNext = (Button) findViewById(R.id.button1);
       btnNext.setEnabled(false);

       editText = (EditText) findViewById(R.id.editText2);

       editText.setOnEditorActionListener(new OnEditorActionListener() {

           @Override
           public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
               // TODO Auto-generated method stub
               if (actionId == EditorInfo.IME_ACTION_DONE) {
                   // do your stuff here
                   btnNext.setEnabled(true);
               }
               return false;
           }
       });

   }


}