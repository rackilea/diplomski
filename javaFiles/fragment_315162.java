LatLngBounds.Builder builder = new LatLngBounds.Builder();
builder.include(first_position_latlng);
builder.include(last_position_latlng);
LatLngBounds bounds = builder.build();
CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding_if_any);
mMap.animateCamera(cu);