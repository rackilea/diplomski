public class PrefsActivity extends PreferenceActivity implements
                                   OnSharedPreferenceChangeListener{
CheckBoxPreference isReg;
@Override
public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.activity_preferences);
    PreferenceManager.setDefaultValues(this,R.xml.activity_preferences, false);
    isReg = (CheckBoxPreference)findPreference("isReg");
    if (isReg != null){
            isReg.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
                @Override
                public boolean onPreferenceChange(Preference preference,
                        Object newValue) {
                    boolean blnIsReg = Boolean.getBoolean(newValue.toString());
                    Editor e = _prefs.edit();
                    e.putBoolean("isReg", blnIsReg);
                    e.commit();
                    return true;
                }
            });
        }
    }
}

@Override
public void onStart(){
    super.onStart();
    _prefs = PreferenceManager.getDefaultSharedPreferences(this);
}