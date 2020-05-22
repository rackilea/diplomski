@Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    Intent intent = getIntent();
    String action = intent.getAction();
    String type = intent.getType();
    String inputText = intent.getStringExtra(Intent.EXTRA_TEXT);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new EphemeralStoragePackage(inputText))
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "BrowseItLater", null);

    setContentView(mReactRootView);

  }