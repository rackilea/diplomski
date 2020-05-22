public class MyAppPreferences {

    private static SharedPreferences getPrefs(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static int getThemeId(Context context, int defaultThemeId) {
        return getPrefs(context).getInt("CurrentThemeId", defaultThemeId);
    }
    public static void setThemeId(Context context, int value) {
        getPrefs(context).edit().putInt("CurrentThemeId", value).commit();
    }

}