protected void onCreate(...) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_layout);

  　// NullPointException here
    ASharedPreferences.saveCurrentNumber(MyActivity.this);
    int n=ASharedPreferences.getCurrentNumber(MyActivity.this);
}