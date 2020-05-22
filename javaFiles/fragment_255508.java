public static Location mLocation; // this is your location

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
try {
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

  getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    getSupportActionBar().hide();
    setContentView(R.layout.activity_main);

    System.loadLibrary("NativeImageProcessor");

    mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

    mFusedLocationClient.getLastLocation()
            .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        mLocation = location; // we pass received location to our global location object
                        // ...
                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();
                         Toast.makeText(MainActivity.this, "Latitude:" + latitude+", Longitude:"+longitude,Toast.LENGTH_SHORT).show();
                    }
                }
            });
           ...
           ...
        takePicture();