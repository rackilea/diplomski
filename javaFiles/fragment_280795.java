@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_another);
    total = (TextView) findViewById(R.id.Total);
    //get result
    Intent intent = getIntent();
    int result = intent.getIntExtra("add", 0);
    total.setText(String.valueOf(result));

  }