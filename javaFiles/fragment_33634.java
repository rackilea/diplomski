public class AppPreference {
    private static SharedPreferences mPrefs;
    private static SharedPreferences.Editor mPrefsEditor;

    public static String getFirstName(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getInt("first_name", "");
    }

    public static void setFirstName(Context ctx, Integer value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putInt("first_name", value);
        mPrefsEditor.commit();
    }
}