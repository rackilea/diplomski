@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // initialize after setContentView
    tv1 = (TextView) findViewById(R.id.textView1);
    tv1.setText("Text2"); // should be within a method
}