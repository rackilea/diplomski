DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference empresaRef = rootRef.child("empresa");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Map<String, Object> map = (Map<String, Object>) ds.getValue();
            //Iterate through the map and get the results
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
empresaRef.addListenerForSingleValueEvent(valueEventListener);