Query query = mRef.orderByChild("email").equalTo("example@example.com");
query.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        // There may be multiple users with the email address, so we need to loop over the matches
        for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
            System.out.println(userSnapshot.getKey());
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // Getting Post failed, log a message
        Log.w(TAG, "find email address:onCancelled", databaseError.toException());
        // ...
    }
});