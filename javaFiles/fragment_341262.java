public class PreferencesActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener{
    private static final String TAG = "PreferencesActivity";

///.... code....

@Override
public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key){
    Log.d(TAG, "onSharedPreferenceChanged() - key = " + key);
    // Yup! The key within the shared preferences was changed... inspect 'em via Log!
}