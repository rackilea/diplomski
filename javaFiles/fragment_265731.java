TextView aTextView; 
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_example);
    aTextView = (TextView ) findViewById(R.id.aTextView);
    aTextView.setText("An example text");
  }