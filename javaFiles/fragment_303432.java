private AppUpdateHelper appUpdateHelper;

@Override
     protected void onCreate(Bundle savedInstanceState) {
     appUpdateHelper = new AppUpdateHelper(getApplicationContext());
     appUpdateHelper.handleAppUpdate();
    }