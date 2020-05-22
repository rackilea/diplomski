private Preferences preferences;
   protected Preferences getPrefs() {
      if(preferences==null){
         preferences = Gdx.app.getPreferences(PREFS_NAME);
      }
   return preferences;
   }