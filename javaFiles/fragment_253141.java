public class MyFragment extends Fragment {

private SupportMapFragment fragment;
private GoogleMap map;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle       savedInstanceState) {
return inflater.inflate(R.layout.layout_with_map, container, false);
}

@Override
public void onActivityCreated(Bundle savedInstanceState) {
super.onActivityCreated(savedInstanceState);
FragmentManager fm = getChildFragmentManager();
fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
if (fragment == null) {
    fragment = SupportMapFragment.newInstance();
    fm.beginTransaction().replace(R.id.map, fragment).commit();
}
}

@Override
public void onResume() {
super.onResume();
if (map == null) {
    map = fragment.getMap();
    map.addMarker(new MarkerOptions().position(new LatLng(0, 0)));
}
}
}