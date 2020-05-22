final ListPreference pref = (ListPreference) findPreference(PREF_NAME);
    CharSequence[] entries = new String[]{getString(R.string.variant1), getString(R.string.variant2)};
    CharSequence[] entryValues = {"variant1", "variant2"};
    pref.setEntries(entries);
    pref.setDefaultValue("variant1");
    pref.setEntryValues(entryValues);