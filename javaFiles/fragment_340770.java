void saveGeoFire(){
    final DatabaseReference yellowRef = FirebaseDatabase.getInstance().getReference().child("driversAvailable").child("drivers").child("YellowLine");
    final DatabaseReference redRef = FirebaseDatabase.getInstance().getReference().child("driversAvailable").child("drivers").child("RedLine");

    final String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

    final DatabaseReference driversRouteRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers").child("Redline").child("bus");
    final DatabaseReference driversRouteRedRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers");
    ValueEventListener redRefEventListenter = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {

                    if(dataSnapshot.child("RedLine").child("bus").getValue().toString().contains(userId)){
                        Toast.makeText(DriverMapActivity.this, "RedLinesuccess", Toast.LENGTH_SHORT).show();
                        GeoFire geoFire = new GeoFire(redRef);
                        geoFire.setLocation(userId, new GeoLocation(mLastLocation.getLatitude(),mLastLocation.getLongitude()));
                    }
                    if(dataSnapshot.child("YellowLine").child("bus").getValue().toString().contains(userId)){
                        Toast.makeText(DriverMapActivity.this, "YellowLine success", Toast.LENGTH_SHORT).show();
                        GeoFire geoFire = new GeoFire(yellowRef);
                        geoFire.setLocation(userId, new GeoLocation(mLastLocation.getLatitude(),mLastLocation.getLongitude()));
                    }

                }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    driversRouteRedRef.addListenerForSingleValueEvent(redRefEventListenter);
}