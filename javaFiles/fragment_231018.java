public class MainActivity extends Activity{

  protected LocationManager locationManager;
  EditText userNumberInput;
  EditText userTextInput;
  TextView distanceText;
  TextView latitude;
  TextView longitude;
  double lat1,lon1,lat2,lon2,lat3,lon3,lat4,lon4;
  double dist = 0;
  String value;
  float[] result;
  private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 0; // in Meters
  private static final long MINIMUM_TIME_BETWEEN_UPDATES = 0;

  // methods omitted

  LocationListener myLocationListener = new LocationListener() 
  {
    public void onLocationChanged(Location loc2) 
    {
      Toast.makeText(MainActivity.this,
      "Location has changed",    
      Toast.LENGTH_LONG).show();
      if(loc2 != null)
      {
        latitude.setText("Current Latitude: " + String.valueOf(loc2.getLatitude())); 
        longitude.setText("Current Longitude: " + String.valueOf(loc2.getLongitude()));
        float[] results = new float[1]; 
        Location.distanceBetween(lat1, lon1, loc2.getLatitude(), loc2.getLongitude(), results);
        System.out.println("Distance is: " + results[0]);               

        dist += results[0];            
        DecimalFormat df = new DecimalFormat("#.##"); // adjust this as appropriate
        distanceText.setText(df.format(dist));

        Toast.makeText(MainActivity.this,
        "Distance",    
        Toast.LENGTH_LONG).show();
        lat1=loc2.getLatitude();
        lon1=loc2.getLongitude();
      }         
    }

  // methods omitted