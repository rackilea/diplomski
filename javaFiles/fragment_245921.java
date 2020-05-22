...
protected SharedPreferences prefs;
    protected static final String PREFS_KEY = "donation";
    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "...", false);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);

        if(prefs.getBoolean("don_ban", false)) //Changed default to false
        {
            banner = (Banner) findViewById(R.id.startAppBanner);
            if(banner != null)
            {
                banner.hideBanner();
            }
        }
        else
        {
            if(banner != null)
            {
                banner.showBanner();
            }
        }

...