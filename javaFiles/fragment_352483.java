public class FragmentCentralParkLocation extends android.support.v4.app.Fragment implements OnMapReadyCallback {

    public FragmentCentralParkLocation() {
        // Required empty constructor
    }

    GoogleMap mGoogleMap;
    MapView mMapView;
    SwitchCompat swt;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_centralpark_location, container, false);

        mMapView = (MapView) v.findViewById(R.id.map_centralpark);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this); //this is important

        swt = (SwitchCompat) v.findViewById(R.id.switch_map_centralpark);

        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        mGoogleMap.setBuildingsEnabled(true);
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               initMap(isChecked);
            }
        });

        initMap(swt.isChecked());

        // Add markers and move the camera
        LatLng knt_location = new LatLng(40.782893, -73.965422);
        mGoogleMap.addMarker(new MarkerOptions()
                .position(knt_location)
        );


        // Updates the location and zoom level of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(40.782893, -73.965422), 18);
        mGoogleMap.animateCamera(cameraUpdate);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    private void initMap(boolean isChecked){
          if(isChecked){
                    mGoogleMap.setMapStyle(new MapStyleOptions(getResources()
                            .getString(R.string.style_json)));    
                }else{
                    mGoogleMap.setMapStyle(null);
                }
    }
}