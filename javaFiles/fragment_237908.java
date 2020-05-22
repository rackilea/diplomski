SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
      @Override
      public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            // Do your stuff
      }
});