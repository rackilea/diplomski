public static final String PREF_LIFES = "Lifes";
public static final String PREF_HINTS = "Hints";
public static final String PREF_LEVEL = "Level";
public static final String PREF_IS_SET = "isSet";


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.menu);

    SharedPreferences pref = getSharedPreferences("SavedGame", MODE_PRIVATE); 

    // Check wether the pref is set or not.
    if (pref.getBoolean(PREF_IS_SET.false)) {
        // The prefs is set. Do some game logic here. Like checking for lifes.
        if (pref.getInt(PREF_LIFES,0) == 0) {
            // Player is "dead", reset it.
            resetPrefs(pref); 
        }
        else {
            // Player is alive, do whatever you want, or do nothing at all.
        }
    }
    else {
        // if it's not set, just create it.
        resetPrefs(pref);
    }

    // ...   
}

private void resetPrefs(SharedPreferences pref) {
    SharedPreferences.Editor editor = pref.edit();      
    editor.putInt(PREF_LIFES, 6);
    editor.putInt(PREF_HINTS, 6);          
    editor.putInt(PREF_LEVEL, 1);
    editor.putBoolean(PREF_IS_SET,true);
    editor.commit();
}