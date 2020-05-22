username.runTransaction(new Transaction.Handler() {
    @NonNull
    @Override
    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
        String name = mutableData.getValue(String.class);
        return Transaction.success(mutableData);
    }

    @Override
    public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
        String username = dataSnapshot.getValue(String.class);
        if(username != null)
            welcome.setText("Welcome back " + username);
    }
});