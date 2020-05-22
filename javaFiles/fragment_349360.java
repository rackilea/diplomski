@Override public View 
onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState)
{
    View view = inflater.inflate(R.layout.map_panel, container, false);
    mapView = (MapView) view.findViewById(R.id.map_view);
    mapView.onCreate(savedInstanceState);
    configureMap(mapView.getMap());
    return view;
}

private void 
configureMap(GoogleMap map, double lat, double lon)
{
    if (map == null)
        return; // Google Maps not available
    try {
        MapsInitializer.initialize(getActivity());
    }
    catch (GooglePlayServicesNotAvailableException e) {
        Log.e(LOG_TAG, "Have GoogleMap but then error", e);
        return;
    }
    map.setMyLocationEnabled(true);
    LatLng latLng = new LatLng(lat, lon);
    CameraUpdate camera = CameraUpdateFactory.newLatLng(latLng);
    map.animateCamera(camera);
}