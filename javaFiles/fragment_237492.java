private final static String PREFS = "myUrlPrefs";

public static String getBaseUrl(Context context) {
    return context.getSharedPreferences(PREFS, MODE_PRIVATE).getString(
        "Name of variable",urlPref);
}