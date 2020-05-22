public class MyActivity extends Activity {

public static final String PREFS_NAME = "MyPrefsFile";

@Override
protected void onCreate(Bundle state){

   super.onCreate(state);
   SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
   boolean dialogShown = settings.getBoolean("dialogShown", false);

   if (!dialogShown) {
     // AlertDialog code here

     SharedPreferences.Editor editor = settings.edit();
     editor.putBoolean("dialogShown", true);
     editor.commit();    
   }
}