@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(Bundle savedInstanceState);
    setContentView(R.layout.activity_main);

    Button myButton = findViewById(R.id.new_button);
    myButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, InsurancePage.class));
        }

    }