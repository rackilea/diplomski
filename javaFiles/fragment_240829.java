public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SharedPreferences pvtPref = getPreferences(MODE_PRIVATE);
    boolean isFirstLaunch = pvtPref.getBoolean("isFirstLaunch", false);
    if (isFirstLaunch) {   // <<<< Syntax Error ?
    // Do Something
    }
}