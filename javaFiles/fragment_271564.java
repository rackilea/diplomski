@Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.product_details);

        Bundle extras = getIntent().getExtras();

        String name = extras.getString("name");

        if (name  != null) {
            TextView text1 = (TextView) findViewById(R.id.textView2);
            text1.setText(name);
        }
    }