DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference destinationRef = rootRef.child("Destination");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            YourClass yourClass = ds.getValue(YourClass.class);
            Log.d(TAG, yourClass.getName());
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
destinationRef.addListenerForSingleValueEvent(valueEventListener);