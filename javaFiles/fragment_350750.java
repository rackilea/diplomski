if (myPosition != null){
    myPosition.setPosition(latLng);
} else {
    myPosition = mMap.addMarker(new MarkerOptions()
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_icon))
            .position(latLng)
            .title("I'm here!"));
}