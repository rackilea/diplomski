public class MyPreferences {

private SharedPreferences pref;

// Editor for Shared preferences
private SharedPreferences.Editor editor;

// Context
private Context context;

// Shared pref mode
int PRIVATE_MODE = 0;

// Sharedpref file name
private static final String PREF_NAME = "MyPreferencesName";

public final static String KEY_NAME = "key_value";

public MyPreferences(Context context) {
    this.context = context;
    pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    editor = pref.edit();
}

public void setFunction(String data) {
    editor.putString(KEY_NAME, data);
    editor.commit();
}

public String getFunction() {
    return pref.getString(KEY_NAME, "");
}
}