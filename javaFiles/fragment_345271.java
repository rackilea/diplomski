Button btn;  // declare here 

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
   setContentView(R.layout.shoppingcart);
   btn = (Button) findViewById(R.id.Checkout);//<<initialize after setContentView
//...your code
}