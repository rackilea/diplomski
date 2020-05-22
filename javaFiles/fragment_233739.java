...
String tb1, tb2, tb3, tb4, tb5;    
double txb1, txb2, txb, txb4, txb5;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fourthxml);

    //text boxes
    txtb1=(EditText)findViewById(R.id.txtb1);
    txtb2=(EditText)findViewById(R.id.txtb2);
    txtb3=(EditText)findViewById(R.id.txtb3);
    txtb4=(EditText)findViewById(R.id.txtb4);
    txtb5=(EditText)findViewById(R.id.txtb5);

    //buttons
    btnper=(Button)findViewById(R.id.btnper);

    //labels/text view
    lblgrade=(TextView)findViewById(R.id.lblgrade);
    lblper=(TextView)findViewById(R.id.lblgrade);

    tb1 = txtb1.getText().toString();
    tb2 = txtb2.getText().toString();
    tb3 = txtb3.getText().toString();
    tb4 = txtb4.getText().toString();
    tb5 = txtb5.getText().toString();

    txb1= Double.parseDouble(tb1);
    txb2= Double.parseDouble(tb2);
    txb3= Double.parseDouble(tb3);
    txb4= Double.parseDouble(tb4);
    txb5= Double.parseDouble(tb5);
}