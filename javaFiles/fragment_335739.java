LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
String provider = locationManager.getBestProvider(new Criteria(), true);

Location locations = locationManager.getLastKnownLocation(provider);
List<String>  providerList = locationManager.getAllProviders();
if(null!=locations && null!=providerList && providerList.size()>0){                 
double longitude = locations.getLongitude();
double latitude = locations.getLatitude();
Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());                 
try {
    List<Address> listAddresses = geocoder.getFromLocation(latitude, longitude, 1);
    if(null!=listAddresses&&listAddresses.size()>0){
        String _Location = listAddresses.get(0).getAddressLine(0);
    }
} catch (IOException e) {
    e.printStackTrace();
}

}