public class GeocoderTask {

LocationManager locationManager;
Location location;
Context context;
String city;

LocationListener locationListener = new LocationListener(){
@Override
    public void onLocationChanged(Location location) {
        GeocoderTask.this.location = location;
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses;
        FrgPersonInfo frgPersonInfo = new FrgPersonInfo();
        System.out.println(city);
        frgPersonInfo.saveUserToTable(s);
        try {
           addresses  = geocoder.getFromLocation(GeocoderTask.this.location.getLatitude(), GeocoderTask.this.location.getLongitude(), 3);
           city = addresses.get(0).getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.getMessage();
        }
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}
    @Override
    public void onProviderEnabled(String provider) {}
    @Override
    public void onProviderDisabled(String provider) {}
}
public GeocoderTask(Context context) {
this.context = context;
locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
}

public void getUpdate(){
locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER,locationListener,null
}