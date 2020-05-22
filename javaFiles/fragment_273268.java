beerPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
     public boolean onPreferenceChange(Preference pref, Object newValue) {
         final ListPreference listPref = (ListPreference) pref;
         final int idx = listPref.findIndexOfValue((String) newValue);

         //Depending upon idx execute
         return true;
     }
 });