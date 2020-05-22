DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("bmbuploads").orderByChild("productName").equalTo("image");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String productImage = ds.child("productImage").getValue(String.class);
            Log.d(TAG, productImage);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);