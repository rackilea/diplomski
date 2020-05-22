public class AppPreferences {
     public static final String KEY_DIFFICULTY = "difficulty";
     private static final String APP_SHARED_PREFS = AppPreferences.class.getSimpleName(); //  Name of the file -.xml
     private SharedPreferences _sharedPrefs;
     private Editor _prefsEditor;

     public AppPreferences(Context context) {
         this._sharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
         this._prefsEditor = _sharedPrefs.edit();
     }

     public String getDifficulty() {
         return _sharedPrefs.getString(KEY_DIFFICULTY, "");
     }

     public void saveDifficulty(String text) {
         _prefsEditor.putString(KEY_DIFFICULTY, text);
         _prefsEditor.commit();
     }
}