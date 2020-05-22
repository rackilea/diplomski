protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wc_line);
    ListView listView = (ListView) findViewById(R.id.listView);
    // Instantiate the list of samples.
    mSamples = new Sample[]{
            new Sample(R.string.bank, R.string.zone_1, MainActivity.class),
            new Sample(R.string.waterloo, R.string.zone_1, MainActivity.class)
    };

    listView.setAdapter(new MyAdapter(this, mSamples));
    }