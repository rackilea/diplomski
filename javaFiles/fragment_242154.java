DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference vendorDtlRef = rootRef.child("vendorDtl");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String vid = ds.child("vid").getValue(String.class);
            Log.d("TAG", vid);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
vendorDtlRef.addListenerForSingleValueEvent(eventListener);