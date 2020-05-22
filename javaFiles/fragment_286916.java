private GoogleMap mMap; 

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_map);

//Add this line.
mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        mMap.addMarker(new MarkerOptions()
        .position(new LatLng(0, 0))
        .title("Hello world"));
}