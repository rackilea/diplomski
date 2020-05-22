EditText checkTotal;
String checkTotalValue;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    checkTotal = (EditText) findViewById(R.id.check_total);
    checkTotalValue = checkTotal.getText().toString();
}