public class ChatFragment extends Fragment implements OnMapReadyCallback {

    private void initilizeMap() {
      //SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);

      SupportMapFragment mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
      mapFrag.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        googleMap = map;
        //Do other stuff..........
    }

}