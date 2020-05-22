@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final  TextView Score = (TextView) findViewById(R.id.Score);
    Button b = (Button)findViewById(R.id.button); //button

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    ...