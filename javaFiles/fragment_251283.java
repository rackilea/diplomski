@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.map);

    manager = (LocationManager) getSystemService(LOCATION_SERVICE);
    tvAddress = (TextView) findViewById(R.id.tvaddress);
    btncurrent= (Button)findViewById(R.id.btncurrent);

    locationClient = new LocationClient(this, this, this);


}