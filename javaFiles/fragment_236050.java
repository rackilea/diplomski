DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("Sign Up").orderByChild("E_Mail").equalsTo("ahmed.elnakib96@xxxx.com");
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
        Log.d(TAG, databaseError.getMessage());
    }
};
query.addListenerForSingleValueEvent(valueEventListener);