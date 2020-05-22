package com.android.nishad.learn.hindi;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class AlphabetActivity extends Activity implements OnClickListener {
   /** Called when the activity is first created. */
   MediaPlayer mp;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_alphabet);

      ImageButton btn = (ImageButton)findViewById(R.id.imageButton1);
      btn.setOnClickListener(this);

      ImageButton btn2 = (ImageButton)findViewById(R.id.imageButton2);
      btn2.setOnClickListener(this);

   }

   public void onClick(View v) 
   {
       switch(v.getId()) 
       {
         case R.id.imageButton1:
             mp = MediaPlayer.create(this, R.raw.lettera);
             break;
         case R.id.imageButton2:
             mp = MediaPlayer.create(this, R.raw.letterb);
             break;
         default:
             return;
       }

      mp.start();
      while (mp.isPlaying()) { 
         // do nothing 
      }
      mp.release();
   }
}