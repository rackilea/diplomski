public void doSomething(@NotNull final Callback callback) {

    final Query query = mDatabase.child(FirebaseConstants.TARGET);

    query.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String userName = dataSnapshot.child("userName").getValue(String.class);
            callback.OnComplete(userName);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
        }
    });
}