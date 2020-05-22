DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference tagsRef = rootRef.child("Tags");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String article_name = ds.child("article_name").getValue(String.class);
            Log.d("TAG", tagsRef);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
tagsRef.addListenerForSingleValueEvent(eventListener);