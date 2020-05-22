@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    TextView text = new TextView(this);

    text.setText("Hello, you owe me 1 000 000€.");

    setContentView(text);
}