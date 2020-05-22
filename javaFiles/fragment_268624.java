protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.google.com")
        );

// Starts Implicit Activity
        startActivity(i);
    }