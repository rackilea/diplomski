@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displayPrice((procente / Double.parseDouble(((EditText) findViewById(R.id.vorgabezeit))
                                .getText().toString())) * mitarbeiter);
                    }
                });
    }