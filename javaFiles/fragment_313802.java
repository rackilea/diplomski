public class MyFragment extends Fragment {

        private SupportMapFragment mSupportMapFragment;
        private GoogleMap mGoogleMap;

 @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.layout_with_map, container, false);
    mSupportMapFragment = new SupportMapFragment() {
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            mGoogleMap = mSupportMapFragment.getMap();
            if (mGoogleMap != null) {
               mGoogleMap.setMyLocationEnabled(true);
            }
        }
    };
    getChildFragmentManager().beginTransaction().replace(mapLayout.getId(), mSupportMapFragment).commit();;
    return view;   
   }
}