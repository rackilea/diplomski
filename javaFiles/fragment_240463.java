ListPreference selected_theme = (ListPreference) getPreferenceManager().findPreference("selected_theme");
selected_theme.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
             return false;
        }
});