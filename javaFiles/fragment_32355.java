Marker carMarker;
@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    if (cardata != null) {
        LatLng latLngCar = new LatLng(cardata.latitude, cardata.longitude);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLngCar);
        markerOptions.title("Car");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker());

        carMarker = mMap.addMarker(markerOptions);
    }


    //.............

}