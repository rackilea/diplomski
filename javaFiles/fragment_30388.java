@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_stack);

    Button buttonClick = findViewById(R.id.buttonClick);
    final EditText editTextData = findViewById(R.id.editTextData);

    buttonClick.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        //this require non null for null string crash  
          Objects.requireNonNull(getSupportActionBar()).setTitle(editTextData.getText().toString());
        }
    });
}