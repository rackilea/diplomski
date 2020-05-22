protected LatLng        mLocation;
    protected GPSManager    mGpsManager;
    private GoogleMap       mGoogleMap;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // get location
        mGpsManager = GPSManager.getInstance();
        mGpsManager.set_mContext(this);
        Location location = mGpsManager.get_mLocation(this);
        mLocation = new LatLng(location.getLatitude(), location.getLongitude());
        // setup map
        mGoogleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        mGoogleMap.setIndoorEnabled(true);
        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLocation.latitude, mLocation.longitude), 8.0f));
    }


    @Override
    protected void onDestroy() {
        clearMap(mGoogleMap);
        super.onDestroy();
    }

    private void clearMap(GoogleMap googleMap) {
        googleMap.clear();
    }