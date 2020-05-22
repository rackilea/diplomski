String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("User").child(uid).child("M3").orderByChild("timestamp").startAt(startTime).endAt(endTime);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            long price = ds.child("price").getValue(Long.class);
            Log.d(TAG, "price: " + long);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
query.addListenerForSingleValueEvent(valueEventListener);