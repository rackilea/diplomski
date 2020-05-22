private SettingsManager(Context context){
   context = cntxt;
   sharedpreferences = context.getSharedPreferences(settingsfile, Context.MODE_PRIVATE);
}


public static SettingsManager getInstance(Context cntxt){
    if(instance == null){        
        instance = new SettingsManager(cntxt);
    }
    return instance;
}