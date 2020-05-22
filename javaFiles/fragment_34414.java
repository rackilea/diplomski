DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference dayOneRef = rootRef.child("Tournaments").child("PMAS").child("Day 1");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Log.d(TAG, "Number of children: " + dataSnapshot.getChildrenCount());
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String month = ds.getKey();
            Log.d(TAG, month);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
dayOneRef.addListenerForSingleValueEvent(valueEventListener);