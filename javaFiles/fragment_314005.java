// wrong code:
// LatLng latitudeStart, longitudeStart;
// LatLng latitudeEnd, longitudeEnd;

// update2: global variables
double latitudeMin = 1000, longitudeMin = 1000;   // better get first value of lat/lon, not 1000
double latitudeMax = -1000, longitudeMax = -1000;  // better get first value of lat/lon, not -1000

...

// test current latitude is min or max
if (latitude < latitudeMin) {
    latitudeMin = latitude;
} else {
    if (latitude > latitudeMax) {
        latitudeMax = latitude;
    }
} 

// test current longitude is min or max
if (longitude< longitudeMin) {
    longitudeMin = longitude;
} else {
    if (longitude> longitudeMax) {
        longitudeMax = longitude;
    }
} 


if (index == 1) {

    image = BitmapDescriptorFactory.fromResource(R.drawable.pin_green);
    mMapSnailTrail.addMarker(new MarkerOptions()
            .position(new LatLng(latitude, longitude))
            .anchor(0.5f, 0.5f)
            .title(location)
            .snippet(remarks)
            .icon(image));

} else if (index == response_last.body().getAsJsonArray().size()) {
    image = BitmapDescriptorFactory.fromResource(R.drawable.pin_red);
    mMapSnailTrail.addMarker(new MarkerOptions()
            .position(new LatLng(latitude, longitude))
            .anchor(0.5f, 0.5f)
            .title(location)
            .snippet(remarks)
            .icon(image));
} else {

}

...