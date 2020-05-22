@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TEST", "BEFORE FINISH");
        finish();
        Log.e("TEST", "AFTER FINISH");
        Log.e("TEST", "AFTER FINISH");

    }