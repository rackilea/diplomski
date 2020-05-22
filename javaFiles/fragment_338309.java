DatabaseReference messageRef = mRootRef.child("messages").child(mCurrentUserId).child(mChatUser);
Query query = messageRef.orderByChild("seen").equalTo(false);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            ds.child("seen").getRef().setValue(true);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);