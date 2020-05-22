@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    mMapFragment = SupportMapFragment.newInstance();
    getSupportFragmentManager().beginTransaction().replace(R.id.sod_map_lite, mMapFragment).commit();
}