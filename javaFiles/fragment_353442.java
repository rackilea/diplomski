private static SharedPreferences mPrefs;
private static SessionManager sInstance = null;

protected SessionManager() {
    mPrefs = AppController.getInstance().getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
}

public static SessionManager getInstance() {
    if (sInstance == null) {
        sInstance = new SessionManager();
    }
    return sInstance;
}