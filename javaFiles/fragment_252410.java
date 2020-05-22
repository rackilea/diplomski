public class MapInfoFragment extends Fragment implements OnMapReadyCallback {
    private static GoogleMap mMap;


    public MapInfoFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_travelling_info, container, false);
        SupportMapFragment mMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frmap);
        lnl_map_fragment = rootView.findViewById(R.id.lnl_map_fragment);
        mMapFragment.getMapAsync(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setMapType(1);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.setTrafficEnabled(false);
        googleMap.getUiSettings().setZoomControlsEnabled(false);
        googleMap.getUiSettings().setRotateGesturesEnabled(false);
        googleMap.getUiSettings().setAllGesturesEnabled(false);
        googleMap.getUiSettings().setTiltGesturesEnabled(false);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        origin_marker_option.position(origin_ltln)
                .title("Origin")
                .icon(BitmapDescriptorFactory.fromBitmap(btm_origin))
                .flat(false);
        googleMap.addMarker(origin_marker_option);

        if (ar_dest_lat_lon.size() > 0) {
            dest_marker_option_1.position(ar_dest_lat_lon.get(0))
                    .title("Dest1")
                    .icon(BitmapDescriptorFactory.fromBitmap(btm_dest_1))
                    .flat(false);
            googleMap.addMarker(dest_marker_option_1);
        } else {
            builder.include(new LatLng(origin_ltln.latitude - 0.003, origin_ltln.longitude - 0.003));
            builder.include(new LatLng(origin_ltln.latitude + 0.003, origin_ltln.longitude + 0.003));
        }


        builder.include(origin_ltln);
        for (LatLng dest_lat_lon : ar_dest_lat_lon)
            builder.include(dest_lat_lon);
        LatLngBounds bounds = builder.build();
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels / 3;
        int padding = (int) (width * 0.12); // offset from edges of the map 12% of screen
        int w = lnl_map_fragment.getWidth();
        int h = lnl_map_fragment.getHeight();
        int p = (int) (w * 0.12);
        try {
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
        } catch (Exception e) {
            e.printStackTrace();
        }
        initMapCameraPosition();
    }

    private void initMapCameraPosition() {
        if (mMap == null) return;

    }
}