@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_geohazard_results);
    String city = getIntent().getStringExtra("city");
    String category = getIntent().getStringExtra("category");
}