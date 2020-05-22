SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Insulin Calculator by Ben Roux");
 mPrefs= getSharedPreferences("label", 0);