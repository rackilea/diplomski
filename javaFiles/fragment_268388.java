@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Declare views
    EditText ptv = (EditText) findViewById(R.id.priceet);
    EditText ttv = (EditText) findViewById(R.id.taxet);
    EditText totaltv = (EditText) findViewById(R.id.totalet);

    //Declare variables
    float price =  0;
    price = Float.valueOf(ptv.getText().toString());
    float tax = 0.0F;
    tax = Float.valueOf(ttv.getText().toString()) / 100;
    float total = price*tax + price;
}