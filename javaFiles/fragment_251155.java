public class ContactFragment extends Fragment implements OnMapReadyCallback{


SupportMapFragment mapFragment;
private GoogleMap mMap;
private ArrayList<Location> array_list;
private Map<Marker, Location> mMarkerHashMap;
View rootView;

public ContactFragment() {

}

 @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    super.onCreateView(inflater, container, savedInstanceState);
    rootView = inflater.inflate(R.layout.fragment_contact, container, false);
    setupMap();
    return rootView;
}

private void setupMap() {
    mMarkerHashMap = new HashMap<>();
    LocationDataSource mLocationDataSource = new LocationDataSource();
    array_list = mLocationDataSource.getList();
    mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);


    for (Location item : array_list) {
       String _title = item.getLocation_name();
        String _snippet = item.getLocation_address();
        LatLng _latLng = new LatLng(item.getLatitude(), item.getLongitude());
        MarkerOptions mMarkerOptions = new MarkerOptions();
        mMarkerOptions.position(_latLng).title(_title).snippet(_snippet).flat(true);
    }
}