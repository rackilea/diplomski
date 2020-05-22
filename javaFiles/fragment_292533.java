public class StoreMapFragment extends Fragment
        implements OnMapReadyCallback {

    SupportMapFragment mMapFragment;
    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        if (mMap == null) {
            final OnMapReadyCallback listener = this;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    if (isAdded()) {
                        mMapFragment = new SupportMapFragment();
                        FragmentManager fm = getChildFragmentManager();
                        fm.beginTransaction()
                                .replace(R.id.map, mMapFragment).commit();
                        mMapFragment.getMapAsync(listener);
                    }
                }
            }, 1000);
        }

        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        loadStores();
    }
}