@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Set the content view like this
    setContentView(this, R.layout.module_home_activity_home);

    mBinding = DataBindingUtil.setContentView(this, R.layout.module_home_activity_home);
    mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    getLifecycle().addObserver(mViewModel);

    initView();
    subscribeUi();

    MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

    mInterstitialAd = new InterstitialAd(this);
    mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
    mInterstitialAd.loadAd(new AdRequest.Builder().build());

    Button tvOk = (Button) findViewById(R.id.tvOk);

    tvOk.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        }
    });

    mPermissionReqHandler = new PermissionReqHandler(self());
}