MapEventsReceiver mReceive = new MapEventsReceiver() {

    @Override
    public boolean singleTapUpHelper(IGeoPoint arg0) {
     Log.d("debug", "Single tap helper");
     //your onSingleTap logic here
    return false;
    }

    @Override
    public boolean longPressHelper(IGeoPoint arg0) {
    Log.d("debug", "LongPressHelper");
    //your onLongPress logic here
    setMarker(arg0);
    return false;
    }
};

//Creating a handle overlay to capture the gestures
MapEventsOverlay OverlayEventos = new MapEventsOverlay(getBaseContext(), mReceive);
map.getOverlays().add(OverlayEventos);

//Refreshing the map to draw the new overlay
map.invalidate();


//I use this method to set the marker on touchPoint
    protected void setMarker(IGeoPoint arg0) {

touchPoint = (GeoPoint) arg0;
targetPoint = touchPoint;
path.addPoint(targetPoint);

//Listener to handle item's(markers) events
 myOnItemGestureListener = new OnItemGestureListener<OverlayItem>() {

    @Override
    public boolean onItemLongPress(int arg0, OverlayItem arg1) {
    Log.d("debug", "Testing long tap on item");
    //your item onLongPress logic here
        return false;
    }

    @Override
    public boolean onItemSingleTapUp(int index, OverlayItem item) {
    Log.d("debug", "Testing single tap on item");
    //your item onSingleTap logic here
        return true;
    }
};

itemarray.add(new OverlayItem("Marker " + cnt, "Info about marker " + cnt, touchPoint));

ItemizedOverlayWithFocus<OverlayItem> overlayDeItems = new ItemizedOverlayWithFocus<OverlayItem>(getBaseContext(), itemarray, myOnItemGestureListener);
map.getOverlays().add(overlayDeItems);

overlayDeItems.setFocusItemsOnTap(true);
map.invalidate();
itemarray = new ArrayList<OverlayItem>();
   cnt++;
}