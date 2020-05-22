public static final String PREFS_NAME = "MyPrefsFile"; // Name of prefs file; don't change this after it's saved something

@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0); // Get preferences file (0 = no option flags set)
    boolean firstRun = settings.getBoolean("firstRun", true); // Is it first run? If not specified, use "true"

    if (firstRun) {
        Log.w("activity", "first time");
        setContentView(R.layout.activity_clean_weather);

        SharedPreferences.Editor editor = settings.edit(); // Open the editor for our settings
        editor.putBoolean("firstRun", false); // It is no longer the first run
        editor.commit(); // Save all changed settings
    } else {
        Log.w("activity", "second time");
        setContentView(R.layout.activity_clean_weather);
    }

}