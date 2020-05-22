public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button wg1 = (Button) findViewById(R.id.button1);
        wg1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(IzzynActivity.this, notes.class);
                IzzynActivity.this.startActivity(myIntent);
            }
        });
        Button wg10 = (Button) findViewById(R.id.button10);
                wg10.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(IzzynActivity.this, calculator.class);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
        });