@Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        //load saved language
        String languageToUse  = ...
        if(languageToUse != null)
        {
            Locale locale = new Locale(languageToLoad); 
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
        this.setContentView(R.layout.main);
    }