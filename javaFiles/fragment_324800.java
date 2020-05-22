public class AppPrefrences {

            private static SharedPreferences mPrefs;
            private static SharedPreferences.Editor mPrefsEditor;

    public static String getUserName(Context ctx) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            return mPrefs.getString("userName", "");
        }

        public static void setUserName(Context ctx, String value) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            mPrefsEditor = mPrefs.edit();
            mPrefsEditor.putString("userName", value);
            mPrefsEditor.commit();
        }

public static void clearAllPreferences(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.clear();
        mPrefsEditor.commit();
    }
        }