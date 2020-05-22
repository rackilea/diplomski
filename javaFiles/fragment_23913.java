DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference shoesRef = rootRef.child("LoadItems").child("Shoes");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String url = ds.getValue(String.class);
            Log.d(TAG, url);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
shoesRef.addListenerForSingleValueEvent(valueEventListener);