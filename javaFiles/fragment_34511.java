private void setRtl(){
    String languageToLoad  = "ar"; // rtl language Arabic
    Locale locale = new Locale(languageToLoad);  
    Locale.setDefault(locale); 

    Configuration config = new Configuration(); 
    config.locale = locale; 
    getBaseContext().getResources().updateConfiguration(config,  
            getBaseContext().getResources().getDisplayMetrics());
            //layout direction 
    Bidi b = new Bidi(languageToLoad,Bidi.DIRECTION_DEFAULT_RIGHT_TO_LEFT);
            b.isRightToLeft();
    //save current locale in SharedPreferences
    SharedPreferences languagepref = getSharedPreferences("language",MODE_PRIVATE);
    SharedPreferences.Editor editor = languagepref.edit();
    editor.putString("languageToLoad",languageToLoad );
    editor.commit(); 

    startActivity(...);// refresh activity.
}