public class SharedPreferenceUtils {

    private static final String SP_NAME = "sp";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";


    // create
    public static boolean createSP(Context context, String username, String password) {
        SharedPreferences.Editor editor = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(USERNAME, username);
        editor.putString(PASSWORD, password);
        return editor.commit();
    }

    // clear
    public static boolean clearSP(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        return editor.clear().commit();
    }

    // get access info
    public static String getUsername(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getString(USERNAME, "");
    }
    // get branch info
    public static String getPassword(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getString(PASSWORD, "");
    }
}