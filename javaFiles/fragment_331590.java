@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display);

    Intent intent = getIntent();

    String message = intent.getStringExtra("message");
    boolean hasError = intent.getBooleanExtra("error", false);

    TextView textView = findViewById(R.id.x);

    textView.setText(message);

    if (hasError) {
        textView.setTextColor(ContextCompat.getColor(this, R.color.error));
    } else {
        textView.setTextColor(ContextCompat.getColor(this, R.color.success));
    }
}