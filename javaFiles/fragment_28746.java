public class Foo extends FragmentActivity implements OnMapReadyCallback {

    private MarkerOptions mrkOpt = new MarkerOptions();
    private LatLng lalg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        try {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("Customers");

            customer= (AddCustomer) getIntent().getSerializableExtra("CustomerData");

            lalg = new LatLng(customer.getLat(), customer.getLng());
            mrkOpt.position(lalg);
            mrkOpt.title(customer.getFname() + customer.getLname())

            mMap.addMarker(mrkOpt);

        }catch (NullPointerException ex)
        {
            Log.d(TAG, "onCreate: " + ex.getMessage());
        }

        search = (EditText)findViewById(R.id.SearchText);
        gps =(ImageView) findViewById(R.id.GpsBtn);
        cust = (ImageView)findViewById(R.id.CusBtn);

        isServiceFine();

        getLocationPermission();

        cust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, CustomerPopUp.class);
                startActivity(intent);
            }
        });
    }
}