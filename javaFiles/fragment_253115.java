@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.settings);

    final ListPreference listPreference = (ListPreference) findPreference("delay");
    String[] array={"1","2","3"};
    CharSequence[] entries = array;
    CharSequence[] entryValues = array;
    listPreference.setEntries(entries);
    listPreference.setDefaultValue("1");
    listPreference.setEntryValues(entryValues);
}