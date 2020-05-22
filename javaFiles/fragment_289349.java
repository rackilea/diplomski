class MainActivity extends AppCompatActivity implements AppSelector {

    private static final String PREFERENCES_NAMESPACE = "checkboxes_states";
    private SharedPreferences checkedAppsPreferences;

    ....

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ....
        checkedAppsPreferences = getSharedPreferences(PREFERENCES_NAMESPACE, 0);
        ....
        AppAdapter installedAppAdapter = new AppAdapter(this, installedApps);
        ....
    }

    @Override
    public void selectApp(String appName) {
        checkedAppsPreferences.edit()
            .putBoolean(appName, true)
            .apply();
    }

    @Override
    public void removeApp(String appName) {
        checkedAppsPreferences.edit()
            .remove(appName)
            .apply();
    }

    @Override
    public boolean isSelected(String appName) {
        return checkedAppsPreferences.contains(appName) && checkedAppsPreferences.getBoolean(appName, false);
    }

    ....
}