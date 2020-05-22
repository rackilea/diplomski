TextView textView,textView2,textView3;  //<<<declare here

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  //initialize all textViews here
  textView = (TextView) findViewById(R.id.textView2);
  textView2 = (TextView) findViewById(R.id.TextView01);
  textView3 = (TextView) findViewById(R.id.TextView03);
  ......