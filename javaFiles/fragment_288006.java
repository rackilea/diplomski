public class MapActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,LocationListener{ 
final String TAG = "mapactivity";
LocationRequest  locationRequest;
GoogleAPiClient googleApiClient;
googleApiClient = new GoogleApiClient.Builder(this)
            .addApi(LocationServices.API)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this).build();
@Override
public void onStart(){
    super.onStart();
    googleApiClient.connect();
}
@Override
public void onStop(){
    googleApiClient.disconnect();
    super.onStop();
}
@Override
public void onConnectionSuspended(int i){
    Log.i(TAG, "Connection suspended");

}
@Override
public void onConnectionFailed(ConnectionResult connectionResult){
    Log.i(TAG, "connection failed");

}
@Override
public void onConnected(Bundle bundle){
    locationRequest = LocationRequest.create();
    locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    locationRequest.setInterval(1000);
    LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
}
@Override
public void onLocationChanged(Location location){
    Double curLat = location.getLatitude();//current latitude
    Double curLong = location.getLongitude();//current longitude
} }