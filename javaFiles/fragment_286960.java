//implicit boxing to use int in Map
Integer ii = Integer.valueOf(i);

//try to get marker by index from map (index is the key)
Marker markerByIndex = markers.get(ii);

//Map.get() returns null if object by specified key is not in map
if (markerByIndex == null){
    //marker doesn't exists - create it, add to Google Map and to Map by key
    timm += 1;
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            final Marker marker =  mMap.addMarker(new MarkerOptions()
                                   .position(new LatLng(depLat, depLon))
                                   .title("Hello world")
                                   .icon(BitmapDescriptorFactory.fromResource(R.drawable.planemarker)));

            //put marker to map using i as a key
            markers.put(ii, marker);
        }
    });
} else {
    //marker exists, mutate it
    markerByIndex.setPosition(position);
    markerByIndex.setVisible(false);

    //...replace the marker in map
    markers.put(ii, markerByIndex);

    //animate the marker
    animateMarker(markerByIndex, position , true, spd);
}