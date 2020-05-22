protected void setFragment(){
    FragmentManager fm = getFragmentManager();
    MapFragment mapFragment =  MapFragment.newInstance();
    fm.beginTransaction().replace(R.id.fragment_container, mapFragment).commit();

    try{
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                //your map related actions.
            }
        });
    }
    catch(Exception e) {
        e.printStackTrace();
    }
}