public class MapboxMarker extends Marker {
    private MyInfoWindow mInfoWindow;

    public class MyInfoWindow extends InfoWindow {

        public MyInfoWindow(int layoutResId, MapView mapView) {
            super(layoutResId, mapView);
        }

        public void onOpen(Marker overlayItem) {
            //
            //  Set data on mInfoWindow.getView()
            //
        }

    }

    public MapboxMarker(MapView mv, LatLng aLatLng, MapController mapController){
        super(mv, "Title", "Description", aLatLng);
    }

    @Override
    protected InfoWindow createTooltip(MapView mv) {
        mInfoWindow = new MyInfoWindow(R.layout.custom_tooltip_layout, mv);
        return mInfoWindow;
    }
}