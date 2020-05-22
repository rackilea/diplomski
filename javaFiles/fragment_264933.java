public class SettingsActivity extends PreferenceActivity {

public static final String TAG = "caveman";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    addPreferencesFromResource(R.xml.pref_general);

    Preference pref = findPreference( "developer" );
    pref.setSummary("Marathon Apps");

    Preference pref1 = findPreference( "version" );
    try {
        pref1.setSummary(appVersion());
    } catch (PackageManager.NameNotFoundException e) {
        e.printStackTrace();
    }
}

@Override
protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    LinearLayout root = (LinearLayout)findViewById(android.R.id.list).getParent().getParent().getParent();
    Toolbar bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.tool_bar, root, false);
    root.addView(bar, 0); // insert at top
    bar.setTitle("Prism");
    bar.setSubtitle("Settings");
    bar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
}

public String appVersion() throws PackageManager.NameNotFoundException {
    PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
    String version = pInfo.versionName;
    return version;
}