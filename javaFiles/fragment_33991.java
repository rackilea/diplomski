DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference assetsRef = rootRef.child("Assets");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String key = ds.getKey();
            Log.d(TAG, key);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
assetsRef.addListenerForSingleValueEvent(valueEventListener);