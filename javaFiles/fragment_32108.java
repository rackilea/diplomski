MyActivity extends Activity implements OnMapClickListener {

    Geocoder geocoder;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        geocoder = new Geocoder(this);
    }

    @Override
    public void onMapClick(LatLng point) {
         List<Address> addresses = geocoder.getFromLocation(point.latitude, point.longitude, 1);

         if (adresses.length > 0) {
             Address address = addresses.get(0);
             Toast.makeText(this, address.getFeatureName(), Toast.LENGTH_SHORT).show();
         }
         else {
             Toast.makeText(this, "Not found!", Toast.LENGTH_SHORT).show();
         }
    }