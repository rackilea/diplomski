public void onSharedPreferenceChanged(SharedPreferences sp, String key) {
    Preference preference = findPreference(key);
    String arrayLang[] = getResources().getStringArray(R.array.lang);
    String arrayCode[] = getResources().getStringArray(R.array.langCode);
    for (int i = 0; i < arrayCode.length; i++) {
         if (arrayCode[i].contains(key)) {
             preference.setSummary(arrayLang[i]);
         }
    }