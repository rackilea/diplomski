DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference shopsRef = rootRef.child("shops");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            for(DataSnapshot dSnapshot : ds.getChildren()) {
                String name = dSnapshot.child("name").getValue(String.class);
                Log.d("TAG", name);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
shopsRef.addListenerForSingleValueEvent(eventListener);