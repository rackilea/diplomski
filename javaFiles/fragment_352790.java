DatabaseReference userMessages = mRootRef.child("Messages").child(mCurrentUser.getUid()).child(mPartnerID);
Query query = query.orderByChild("seen").equalsTo(false);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            ds.child("seen").getRef().setValue(true);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);