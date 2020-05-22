@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ....

    TextView refereeAndDate = findViewById(R.id.refereeAndDate);
    String string = getIntent().getStringExtra("SHARED_CONTENT");
    refereeAndDate.setText(string);
}