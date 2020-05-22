DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference dataRef = rootRef.child("data");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
            String parentKey = dSnapshot.getKey();

            for(DataSnapshot ds : dSnapshot.getChildren()) {
                String key = ds.getKey();

                String key1 = ds.child("Key1").getValue(String.class);
                String key2 = ds.child("Key2").getValue(String.class);
                Log.d(TAG, key1 + " / " + key2);
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
dataRef.addListenerForSingleValueEvent(valueEventListener);