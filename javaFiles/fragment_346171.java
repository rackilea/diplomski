protected GoogleApiClient mGoogleApiClient;
protected SupportMapFragment mapFragment;
protected GoogleMap mMap;
@Override
protected void onCreate(Bundle savedInstanceState) {
    Log.i(TAG, "onCreate");
    mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
}

@Override
protected void onStart() {
    Log.i(TAG, "onStart");
    mGoogleApiClient.connect();
    super.onStart();
}

@Override
protected void onStop() {
    Log.i(TAG, "onStop");
    mGoogleApiClient.disconnect();
    super.onStop();
}

@Override
public void onResume() {
    Log.i(TAG, "onResume");
    super.onResume();

    //Added:
    if (mMap == null) {
      mapFragment.getMapAsync(this);
    } else {
      doSomeSeriousWork();
    }
}

@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    Log.i(TAG, "onMapReady");
    doSomeSeriousWork();
}

public void doSomeSeriousWork() {
    // do some serious work here
}