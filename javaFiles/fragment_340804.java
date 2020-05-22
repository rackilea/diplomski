@EActivity
public class SettingsActivity extends PreferenceActivity {

    @Pref
    MyPrefs_ myPrefs;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesName("MyPrefs");
        addPreferencesFromResource(R.xml.preferences);
    }

}