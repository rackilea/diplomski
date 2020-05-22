DatabaseReference balanceRef = FirebaseDatabase.getInstance().getReference("/Users/"+ user_id +"/Balance");
Long delta = 50l;
balanceRef.runTransaction(new Transaction.Handler() {
    @Override
    public Transaction.Result doTransaction(MutableData mutableData) {
        Long balance = mutableData.getValue(Long.class);
        if (balance == null) {
            mutableData.setValue(delta);
        }
        else {
            Long amount = mutableData.getValue(Long.class);
            amount = amount + delta;
            mutableData.setValue(amount);
        }
        return Transaction.success(mutableData);
    }

    @Override
    public void onComplete(DatabaseError databaseError, boolean b,
                           DataSnapshot dataSnapshot) {
        // Transaction completed
        Log.d(TAG, "balanceTransaction:onComplete:" + databaseError);
    }
});