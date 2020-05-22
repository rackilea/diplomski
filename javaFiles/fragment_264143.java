public class ChildTrackerPage extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ConnectionHTTP myCon = new ConnectionHTTP();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_tracker_page);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void goToMenu(View view) {
        Intent i1 = new Intent(this, UserHome.class);
        startActivity(i1);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private class GetJSON extends AsyncTask<String, Void, String> {

        @Override
        public String doInBackground(String... strings) {
            HashMap<String,String> hashMap=new HashMap<>();
            return myCon.postRequest(hashMap, "http://webgax.com/schoolapp/fetch.php");
        }

        @Override
        public void onPostExecute(String s) {
            JSONObject jsonObject = new JSONObject(s);
            //I'm not sure why you do that instead of just using optDouble on your JSON but I don't know the contect of your JSON
            String longVal = jsonObject.getString("lat");
            String latVal = jsonObject.getString("lng");
            double latNum = Double.parseDouble(latVal);
            double longNum = Double.parseDouble(longVal);

            LatLng addr = new LatLng(latNum, longNum);
            float zoomLevel = 16; //This goes up to 21

            if(mMap!=null){
                mMap.addMarker(new MarkerOptions().position(addr).title("WebGax"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(addr, zoomLevel));
            }
        }

    }

}