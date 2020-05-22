public class LocationSender {
Context context;
LocationManager locationManager;
Location location;
static double lat,lng;
public LocationSender(Context ctx) {
context=ctx;
locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
}

// Acquire a reference to the system Location Manager
public void getNewLocation(Location location) throws JSONException 
{
String latLongString = "";
if (location != null) {
    this.location=location;
  lat= location.getLatitude();
   lng = location.getLongitude();
    latLongString = "Lat:" + String.valueOf(LocationActivity.lat) + "\nLong:" +        String.valueOf(LocationActivity.lng);
    Log.d("Location Found", latLongString);
   } else
  {
    location=null;
    latLongString = "No location found";
}
Toast.makeText(context, latLongString, Toast.LENGTH_LONG).show();
 }

 LocationListener locationListener = new LocationListener() {
 public void onLocationChanged(Location location) {
  // Called when a new location is found by the network location provider.
    try {
        getNewLocation(location);
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }

   }



   public void onProviderEnabled(String provider) {

    Toast.makeText(context, "Provider: "+provider+" : Enabled", Toast.LENGTH_LONG).show();
    }

    public void onProviderDisabled(String provider) {

    Toast.makeText(context, "Provider: "+provider+" : disabled", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    Toast.makeText(context, "Provider: "+provider+" : status: "+status, Toast.LENGTH_LONG).show();

    }
    };    

    }