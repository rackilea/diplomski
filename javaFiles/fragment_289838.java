@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Fetching the link from the Intent.
    String link = getIntent().getStringExtra("link");

    // .. display the link