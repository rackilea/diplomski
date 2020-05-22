private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            SetupActionBar();

            try {
                setContentView(R.layout.activity_near_by_deals_details);
                try {

                   context = this;
                   if (googleMap == null) {
                      googleMap = ((MapFragment) getFragmentManager()
                                 .findFragmentById(R.id.map)).getMap();
                   }
                   DrawPoint(pass param if needed);
        }


    public void DrawPoint(String param) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            MarkerOptions marker = new MarkerOptions().position(new LatLng(LAT, LON)).title(name);
            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
            googleMap.addMarker(marker);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                    new LatLng(LAT, LON)).zoom(15).build();

            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.getUiSettings().setZoomGesturesEnabled(true);
        }