DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Buy");
databaseReference.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        // Let us retrieve value of location
        Log.i("Price", dataSnapshot.child("location").getValue().toString());
        // In this way you can retrieve all the fileds.
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
    }
});