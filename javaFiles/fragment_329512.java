DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference locationsRef = rootRef.child("Locations");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String latitude = ds.child("Latitude").getValue(String.class);
            String longitude = ds.child("Longitude").getValue(String.class);
            LatLng latLng = new LatLng(String.valueOf(latitude), String.valueOf(longitude));
            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("My Marker");
            Marker marker = googleMap.addMarker(markerOptions);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
locationsRef.addListenerForSingleValueEvent(valueEventListener);