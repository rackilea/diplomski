@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ractivity); // your second layout file

    TextView textView = (TextView) findViewById(R.id.textView); 
    String stringResult = getIntent().getStringExtra(EXTRA_MESSAGE);
    String textViewText = "Hello "+ stringResult +". Are you sure you want to accept these terms?";
    textView.setText(textViewText);

}