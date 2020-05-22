public class MyFragment extends Fragment {

    private SupportMapFragment mSupportMapFragment;
    private GoogleMap mGoogleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_with_map, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        mSupportMapFragment =  SupportMapFragment.newInstance();
        fm.beginTransaction().replace(mapLayout.getId(),mSupportMapFragment).commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mGoogleMap == null) {
            mGoogleMap = mSupportMapFragment.getMap();
        }
    }
}