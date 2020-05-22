@Override 
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    Log.i(TAG, "oncreate");
    View rootView = inflater.inflate(R.layout.yourmap, container, false);

     // Gets the MapView from the XML layout and creates it
    mapView = (MapView) rootView.findViewById(R.id.mapview);
    mapView.onCreate(savedInstanceState);
    setCurrentLocationMarker();

    return rootView;
}

public void setCurrentLocationMarker(){
    try {
    // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);

        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            Log.e(TAG , "Exception: "+e.getMessage());
            e.printStackTrace();
        }

        gps = new GPSTracker(getActivity());

        if(gps.canGetLocation()) {

            myLatitude = gps.getLatitude();
            myLongitude = gps.getLongitude();

            if(myLatitude==0 && myLongitude==0){
                LocationManager lm = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE); 
                Location location = getLastKnownLocation(lm);
                Log.i(TAG, "location : "+location);
                if(location!=null){
                     myLatitude = location.getLatitude();
                     myLongitude = location.getLongitude();
                }
            }

        } else {
            // Can't get location.
            // GPS or network is not enabled.
            // Ask user to enable GPS/network in settings.
            gps.showSettingsAlert();
            Log.i(TAG, "gps.canGetLocation() : "+gps.canGetLocation());
            return;
        }

        Log.i(TAG, "myLatitude  :"+myLatitude+", myLongitude: "+myLongitude);


        // Updates the location and zoom of the MapView
        if(myLatitude>0 && myLongitude>0){
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(myLatitude, myLongitude), 10);
            map.animateCamera(cameraUpdate);

            MarkerInfo markerinfo = new MarkerInfo("", "Current Location", myLatitude, myLongitude, true);
            addMarker(markerinfo);
        }


        map.setOnMarkerClickListener(onClickListener);
        map.setOnInfoWindowClickListener(onInfoWindowClickListener);            
        marker.showInfoWindow();

    } catch (Exception e) {
       Log.e(TAG, "Exception : "+e.getMessage());
    }
}