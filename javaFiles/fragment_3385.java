DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference newsRef = rootRef.child("News");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String desc = ds.child("desc").getValue(String.class);
            String title = ds.child("title").getValue(String.class);
            Log.d(TAG, desc + " / " + title);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
newsRef.addListenerForSingleValueEvent(valueEventListener);