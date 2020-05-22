String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
Query listpayment = mFirebaseDatabase.getReference()
    .child("paymentIDs")
    .child(uid)
    .orderByChild("date")
    .startAt(fromdateinLong).endAt(todateinLong);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String userId = ds.child("userId").getValue(String.class);
            Log.d(TAG, userId);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
listpayment.addListenerForSingleValueEvent(valueEventListener);