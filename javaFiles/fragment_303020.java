@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    mMapFragment = MapFragment.newInstance();
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
        getChildFragmentManager().beginTransaction().replace(R.id.map_id, mMapFragment).commit();
    } else {
        getFragmentManager().beginTransaction().replace(R.id.map_id, mMapFragment).commit();
    }
    mMapFragment.getMapAsync(this);
}