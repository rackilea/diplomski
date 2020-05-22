@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Intent intent = getIntent();
    String message= intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    textView = (TextView)findViewById(R.id.textViewdata);
    textView.setText(message);

    setContentView(R.layout.activity_show_second);
}