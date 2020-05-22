private void geoLocate() throws IOException {
    String location = "comida rapida y pizza";
    Geocoder gc = new Geocoder(this);
    List<Address> list = new ArrayList<>(gc.getFromLocationName(location, 1));

    if (list != null && list.size() > 0) {
        Address address = list.get(0);
        String locality = address.getLocality();

        Toast.makeText(this, locality, Toast.LENGTH_SHORT).show();

        double lat = address.getLatitude();
        double lng = address.getLongitude();
        goToLocationZoom(lat, lng, 16);
    } else {
        Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show();
    }
}