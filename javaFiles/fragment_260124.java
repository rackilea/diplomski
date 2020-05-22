SharedPreferences sp;
String name;

@Override
public void onCreate() {
    super.onCreate();
    sp = PreferenceManager.getDefaultPreferences(getApplicationContext());
    name = sp.getText("namepreferences", "NA");
}