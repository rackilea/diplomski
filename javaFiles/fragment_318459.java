DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference userRef = rootRef.child("user");
Query query = userRef.orderByChild("totalNumberOfSteps");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String username = ds.child("username").getValue(String.class);
            long totalNumberOfSteps = ds.child("totalNumberOfSteps").getValue(Long.class);
            Log.d(TAG, username + " - Steps: " + totalNumberOfSteps);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);