super.onCreate(savedInstanceState);

Intent intent0 = getIntent();
boolean showSplash = getIntent().getBooleanExtra(Registration.FLAG_KEY), true);

handleSplashScreen(showSplash);