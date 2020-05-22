public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Intent i;
    MarkerOptions markerOption;
    List<Target> targets;
    HashMap<Marker, MyMarker> mMarkersHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mMarkersHashMap = new HashMap<>();
        targets = new ArrayList<>();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        ArrayList<MyMarker> markers = new ArrayList<MyMarker>();
        MyMarker m1 = new MyMarker(new LatLng(-34, 151.1), "https://developer.chrome.com/extensions/examples/api/idle/idle_simple/sample-128.png");
        MyMarker m2 = new MyMarker(new LatLng(-34, 151.2), "https://developer.chrome.com/extensions/examples/api/idle/idle_simple/sample-128.png");
        MyMarker m3 = new MyMarker(new LatLng(-34, 151.3), "https://developer.chrome.com/extensions/examples/api/idle/idle_simple/sample-128.png");

        markers.add(m1);
        markers.add(m2);
        markers.add(m3);

        plotMarkers(markers);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Log.d(MapsActivity.class.getSimpleName(), "MARKER Longitude: " + marker.getPosition().longitude);
                return false;
            }
        });
    }

    public void plotMarkers(ArrayList<MyMarker> markers) {
        if (markers.size() > 0) {
            for (MyMarker myMarker : markers) {

                markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));
                Marker location_marker = mMap.addMarker(markerOption);

                Target target = new PicassoMarker(location_marker);
                targets.add(target);
                Picasso.with(MapsActivity.this).load(myMarker.getmIcon()).resize(84, 125).into(target);

                mMarkersHashMap.put(location_marker, myMarker);

                i = getIntent();
                if (i.getBooleanExtra("maps", true)) {
                    // buttonNavigasi.setVisibility(View.VISIBLE);

                    location_marker.setTitle(i.getStringExtra("nama"));
                    LatLng dest = new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude());
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dest, 8f));
                } else {
                    Log.d(MapsActivity.class.getSimpleName(), "In else{}");
                    // mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
                }
            }
        }
    }
}