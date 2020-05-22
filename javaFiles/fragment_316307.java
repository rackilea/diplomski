SharedPreferences settings = getSharedPreferences("mysettings", 
     Context.MODE_PRIVATE);

SharedPreferences.Editor editor = settings.edit();
editor.putString("mystring", "wahay");
editor.commit();