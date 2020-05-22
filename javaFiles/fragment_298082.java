/**
 * This method is used to set shared preferences
 * @param context Application context
 * @param key shared object key
 * @param value shared object value
 */
public static void setPreferences(Context context, String key, String value) {
    SharedPreferences appSharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(context);
    Editor prefsEditor = appSharedPrefs.edit();
    prefsEditor.putString(key, value);
    prefsEditor.commit();
}

/**
 * This method is used to get shared object
 * @param context Application context
 * @param key shared object key
 * @return return value, for default "" asign.
 */
public static String getPreferences(Context context, String key) {

    SharedPreferences appSharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(context);

    String json = appSharedPrefs.getString(key, "");
    if (TextUtils.isEmpty(json)) {
        return null;
    }
    return json;
}