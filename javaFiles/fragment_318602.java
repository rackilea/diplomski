public MyModule(Context applicationContext) {
    SharedPreferences prefs = PreferenceManager.getSharedPreferences(applicationContext);
    prefsHelper = new SharedPreferencesHelper(prefs);
}

@Provides
@Singleton
public SharedPreferencesHelper providePrefsHelper() {
    return prefsHelper;
}