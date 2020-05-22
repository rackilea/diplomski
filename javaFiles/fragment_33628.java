DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("test").orderByChild("name");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            long score = ds.child("score").getValue(Long.class);
            Log.d(TAG, "Score: " + score);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
query.addListenerForSingleValueEvent(valueEventListener);