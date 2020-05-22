public class MyMapFragment extends SupportMapFragment
{
    private LatLng  latLon;

    public MyMapFragment()
    {
        super();
    }

    public static MyMapFragment newInstance(LatLng position)
    {
        MyMapFragment frag = new MyMapFragment();
        frag.latLon = position;
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        initMap();
        return v;
    }

    private void initMap()
    {
        UiSettings settings = getMap().getUiSettings();
        settings.setAllGesturesEnabled(false);
        settings.setMyLocationButtonEnabled(false);

        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(latLon, 16));
        getMap().addMarker(new MarkerOptions().position(latLon).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
    }
}