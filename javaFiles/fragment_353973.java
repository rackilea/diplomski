@Override
public void onLocationChanged(Location location) {

    //now that we got the initial location. it is time to stop the api client
    LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    mGoogleApiClient.disconnect();

   // use your newly obtained location here

}