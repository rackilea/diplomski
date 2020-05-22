DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference dataRef = rootRef.child("data");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String value_1 = ds.child("xxx").child("value_1").getValue(String.class);
            boolean value_2 = ds.child("xxx").child("value_2").getValue(Boolean.class);
            Log.d(TAG, value_1 + " / " + value_2);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
dataRef.addListenerForSingleValueEvent(valueEventListener);