@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_layout);

    Intent intent = getIntent();
    String data = intent.getStringExtra("MY_EXTRA_DATA");

    TextView textView = (TextView) findViewById(R.id.yourId);
    textView.setText(data);
}