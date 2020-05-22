public class PrefsActivity extends PreferenceActivity {

    public PrefsActivity() {
        // TODO Auto-generated constructor stub
    }
@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.prefs);
    ListPreference     lp1 = (ListPreference) findPreference(getString(R.string.lp1)); 
    CheckBoxPreference cb2 = (CheckBoxPreference) findPreference(getString(R.string.cb2)); 
    lp1.setEnabled(false);
    cb2.setEnabled(false);
    EditTextPreference etp1 = (EditTextPreference) findPreference(getString(R.string.mypassword)); 

    String  mypassword =PreferenceManager.getDefaultSharedPreferences(this).getString(getString(R.string.mypassword), "0");

  if ("THE_PASSWORD".equals(mypassword)) {
        lp1.setEnabled(true);
        cb2.setEnabled(true);
    }

}

}