DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String key = ds.getKey();
            list.add(key);
            Log.d(TAG, key);
        }

        //Do what you need to do with your list
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
rootRef.addListenerForSingleValueEvent(valueEventListener);