DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("bus_tracking").child("service_no");
databaseReference.child(busId).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot mainSnapshot) {

       String lat = mainSnapshot.child("lat").getValue(String.class);
    }
    @Override
    public void onCancelled(DatabaseError databaseError) {
     Log.d(TAG,databaseError.getMessage());

    }
});