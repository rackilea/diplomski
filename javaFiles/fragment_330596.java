private static final LatLng NEBOUND = new LatLng(47.671781, -117.393352);
private static final LatLng SWBOUND = new LatLng(47.661283, -117.411052);
private static final LatLngBounds MAPBOUNDARY = new LatLngBounds(SWBOUND, NEBOUND);
private LatLng lastCenter = new LatLng(47.667454, -117.402309);
GoogleMap guMap;
private Handler mHandler;

private void checkBoundaries(){
    LatLng tempCenter = guMap.getCameraPosition().target;
    LatLngBounds visibleBounds = guMap.getProjection().getVisibleRegion().latLngBounds;
    if(!MAPBOUNDARY.contains(visibleBounds.northeast) || !MAPBOUNDARY.contains(visibleBounds.southwest)){
        guMap.moveCamera(CameraUpdateFactory.newLatLng(lastCenter));
    }
    else
        lastCenter = tempCenter;
}

private void setUpHandler(){
    mHandler = new Handler(){
            public void handleMessage(Message msg){
                checkBoundaries();
                sendEmptyMessageDelayed(0, 5);
            }
        };
}