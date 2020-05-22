protected synchronized void buildGoogleApiClient() {
 mGoogleApiClient = new GoogleApiClient.Builder(this)
    .addConnectionCallbacks(this)
    .addOnConnectionFailedListener(this)
    .addApi(LocationServices.API)
    .build();
}


public class MainActivity extends ActionBarActivity implements
    ConnectionCallbacks, OnConnectionFailedListener {
...
@Override
public void onConnected(Bundle connectionHint) {
    mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
            mGoogleApiClient);
    if (mLastLocation != null) {
        mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
        mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
      }
  }
}