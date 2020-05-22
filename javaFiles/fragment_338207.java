public class shopView extends Activity
{
    TextView confirmPurchaseTest;
    String temp = "temp";

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopview);

        Button btnRef1 = (Button) findViewById(R.id.btnbtnRef11);
        confirmPurchaseTest = (TextView) findViewById(R.id.tvMigName);

        btnRef1.setOnClickListener(new View.OnClickListener()
        {   
            @Override
            public void onClick(View v) {
                temp = "passed value";
                confirmPurchaseTest.setText("item Purchased");
                buyFromShop();
                Log.v("after button push", "temp");
            }
        });
    }

    public String buyFromShop(){
        Log.v("button push", "after buy from shop");
        Log.v("temp variable", temp);

        // Change this!
        return confirmPurchaseTest.getText().toString();
    }

}