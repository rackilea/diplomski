public void onLocationChanged(Location mylocation) {

    logEvent("onLocationChanged");

    //mlastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    mlastLocation = mCurrentLocation;
    mCurrentLocation = mylocation;
    if (mlastLocation != null) {
        plotroute(mylocation);      
    }           
    mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());
}