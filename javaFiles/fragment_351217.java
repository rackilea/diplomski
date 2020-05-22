public void getUserData(){
    String uID = mAuth.getCurrentUser().getUid();
    myRef.child(uID).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            dataSnapshot.getChildren();
            user = dataSnapshot.getValue(User.class);
            LatLng userL = new LatLng(user.getLat(),user.getLng());
            if(mMap!=null){
               mMap.clear();
               mMap.addMarker(new MarkerOptions().position(userL).title("Your 
               Location"));
             mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userL,17));
            }
            Toast.makeText(Profile.this, "" + user.lng, Toast.LENGTH_LONG).show(); // Prints the value normally!

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Toast.makeText(Profile.this, "Failed to read from database!", Toast.LENGTH_LONG).show();
        }
    });
}

@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
}