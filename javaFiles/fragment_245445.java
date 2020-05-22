public class Visited_Places extends FragmentActivity implements OnMapReadyCallback {

    DatabaseHelper databaseHelper;

    ArrayList<HashMap<String, Object>> alllocation = new ArrayList<HashMap<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited__places);
        databaseHelper = new DatabaseHelper(this);
        alllocation = get_location();
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.maps);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
//put multiple location map
        if (googleMap != null) {
            for (int i = 0; i < alllocation.size(); i++) {
                HashMap<String, Object> hash = alllocation.get(i);
                Double lat = (Double) hash.get("latitude");
                Double lang = (Double) hash.get("longitude");
                String address = hash.get("address").toString();

                if (i == 0) {
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lang), 14));

                }
                googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lang))
                        .title(address));


            }
        }


    }
    //getting location from database  
    ArrayList<HashMap<String, Object>> get_location(){

        ArrayList<HashMap<String, Object>> location = new ArrayList<HashMap<String, Object>>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select address,latitude,longitude from "+Table_Name_Location,null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()) {
                Double latitude = cursor.getDouble(cursor.getColumnIndex(Latitude));
                Double longitude = cursor.getDouble(cursor.getColumnIndex(Longitude));
                //get your address
                String address = cursor.getString(cursor.getColumnIndex(Address));

                HashMap<String, Object> hash = new HashMap<String, Object>();
                hash.put("latitude", latitude);
                hash.put("longitude", longitude);
                hash.put("address", address);
                location.add(hash);
            }
        }
        cursor.close();
        return location;
    }
}