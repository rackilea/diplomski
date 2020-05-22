CheckBoxPreference cbp_white = (CheckBoxPreference) findPreference("colour_white");
CheckBoxPreference cbp_red = (CheckBoxPreference) findPreference("colour_red");

cbp_white.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {            
            public boolean onPreferenceChange(Preference preference, Object newValue) {
               //write your logic here
                //Example: cbp_red.setChecked(false);
                return true;
            }
        });