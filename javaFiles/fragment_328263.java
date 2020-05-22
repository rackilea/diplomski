DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
Query delQuery = ref.child("Posts").orderByChild("date").equalTo(DateYouKnowIsThere);

delQuery.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot dSnapshot: dataSnapshot.getChildren()) {
            dSnapshot.getRef().removeValue();
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.e(TAG, "onCancelled", databaseError.toException());
    }
});