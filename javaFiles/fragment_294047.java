package com.test.app;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

   public static int count = 0;

   @Override
   public void onCreate() {

      Log.d("COUNT", String.valueOf(count));
      count++;
  }
}