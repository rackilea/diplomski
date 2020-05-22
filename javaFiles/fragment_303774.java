String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("bookings").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String desk = ds.child("desk").getValue(String.class);
            String userId = ds.child("userId").getValue(String.class);
            Log.d("TAG", desk + " / " + userId);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
uidRef.addListenerForSingleValueEvent(valueEventListener);