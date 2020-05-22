@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //get the message from the intent
    Intent intent = getIntent();
    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    //create the text view
    TextView textView = new TextView(this);
    textView.setTextSize(40);
    textView.setText(message);

    //Set the text view as the activity layout
    setContentView(textView);
}