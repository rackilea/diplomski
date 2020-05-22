SharedPreferences settings = getSharedPreferences("MyPrefs", 0);
   boolean firstTime = settings.getBoolean("FirstTime", true);
   if (firstTime) {
       // execute your one time code...
       // change the value in the shared preferences:
       SharedPreferences.Editor editor = settings.edit();
       editor.putBoolean("FirstTime", false);
       editor.commit();
   }