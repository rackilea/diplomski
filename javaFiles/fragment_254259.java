public class MyMapActivity extends Activity {

 private GoogleMap googleMap;
 private GoogleApiClient mGoogleApiClient;
 protected Location mLastLocation;

  @Override
  public void onCreate(Bundle inState) {
  // do whatever initialization including one for googleMap
     mGoogleApiClient = new GoogleApiClient.Builder(this)
     .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {

          @Override
          public void onConnected(Bundle arg0) {
             // this is where you got your last location
             mLastLocation = LocationServices.FusedLocationApi
             .getLastLocation(mGoogleApiClient);
             // then center on map
             LatLng mLatLng = new LatLng(mLastLocation.getLatitude(),
             mLastLocation.getLongitude());
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom
             (mLatLng, 14), 1000, null);

           }

           @Override
             public void onConnectionSuspended(int arg0) {
           }

     })
     .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {

           @Override
           public void onConnectionFailed(ConnectionResult conResult) {
             if (conResult.hasResolution()){
              try{
                conResult.startResolutionForResult(MyMapActivity.this,
                CONNECTION_FAILURE_RESOLUTION_REQUEST);
               }catch(SendIntentException e){
                    e.printStackTrace();
               }                    
              }
             }})
     .addApi(LocationServices.API)
     .build();
  }

}


  @Override
  protected void onStart() {
    super.onStart();
    mGoogleApiClient.connect();
  }

  @Override
  protected void onStop() {
    super.onStop();
    mGoogleApiClient.disconnect();
  }