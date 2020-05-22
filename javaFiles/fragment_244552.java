public class Activity {
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    boolean appcrashed=false;
    super.onCreate(savedInstanceState);
    boolean didUserLeft=loadSavedPreferences();
    appcrashed=!didUserLeft;
    if(appcrashed)
        Toast.makeText(this, "App Crashed!", Toast.LENGTH_LONG).show();
    else
        Toast.makeText(this, "App OK!", Toast.LENGTH_LONG).show();
    savePreferences(false);

    UnhandledExceptionHandler handler = new UnhandledExceptionHandler();

    Thread.setDefaultUncaughtExceptionHandler(handler);

}


public boolean loadSavedPreferences() {
    SharedPreferences sharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(this);
    boolean didUserLeft = sharedPreferences.getBoolean("didUserLeft", true);
    return didUserLeft;
}

public void savePreferences(boolean value) {
    SharedPreferences sharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(this);
    Editor editor = sharedPreferences.edit();
    editor.putBoolean("didUserLeft", value);
    editor.commit();
}

@Override
public void onResume(){
    super.onResume();
    savePreferences(false);
}

@Override
public void onDestroy(){
    savePreferences(true);
}

@Override
public void onPause() {
    super.onPause();  // Always call the superclass method first
    savePreferences(true);
    }


@Override
public void onUserLeaveHint(){
    savePreferences(true);
}