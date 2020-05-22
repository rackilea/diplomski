@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

EditText checkTotal = (EditText) findViewById(R.id.check_total);
String checkTotalValue = checkTotal.getText().toString();