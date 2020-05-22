protected void onPause() {
     super.onPause();

    // save count value here
   SharedPreferences.Editor editor = app_preferences.edit();
   editor.putInt("count", count);
   editor.commit();
 }