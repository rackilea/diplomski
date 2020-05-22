public class GPSLocationManager implements LocationObservable {
private static final long INTERVAL = 10*1000;
private LocationManager locationManager;

public GPSLocationManager(LocationManager locationManager) {
this.locationManager = locationManager; 
}

 public void requestLocationUpdates(LocationListener locationListener) {
  locationManager.requestLocationUpdates(
    LocationManager.GPS_PROVIDER, 
    INTERVAL, 
    0, locationListener);
}

public void removeUpdates(LocationListener locationListener) {
  locationManager.removeUpdates(locationListener);
}

}