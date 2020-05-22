public class LocationHandler implements implements LocationListener{
LocationManager mLocationManager;

  public void Setup(){
    mLocationManager = (LocationManager) getApplicationContext()
            .getSystemService(LOCATION_SERVICE);
    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
            500, 10, this);
  }

  @Override
  public void onLocationChanged(Location location) {
    //do something with your location
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {}

  @Override
  public void onProviderEnabled(String provider) {}

  @Override
  public void onProviderDisabled(String provider) {}
  }
}