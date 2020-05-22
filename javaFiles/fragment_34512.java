private void setLtr(){
   String languageToLoad  = "en"; // ltr language English
   Locale locale = new Locale(languageToLoad);  
   Locale.setDefault(locale); 

   Configuration config = new Configuration(); 
   config.locale = locale; 
   getBaseContext().getResources().updateConfiguration(config,  
        getBaseContext().getResources().getDisplayMetrics());
        //layout direction 
   Bidi b = new Bidi(languageToLoad, Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
            b.isLeftToRight();
   //save current locale in SharedPreferences
   SharedPreferences languagepref = getSharedPreferences("language",MODE_PRIVATE);
   SharedPreferences.Editor editor = languagepref.edit();
   editor.putString("languageToLoad",languageToLoad );
   editor.commit(); 

   startActivity(...);// refresh activity.