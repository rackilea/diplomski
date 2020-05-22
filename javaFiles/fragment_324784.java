public class MyLocationListener implements LocationListener 
{

     @Override

     public void onLocationChanged(Location loc)
     {
        float latitude = loc.getLatitude(); //Retrieve the latitude
        float longitude = loc.getLongitude(); //Retrieve the longitude
        Toast.makeText( getApplicationContext(),"Current location: "+latitude+","+longitude,Toast.LENGTH_SHORT).show();
    }
}