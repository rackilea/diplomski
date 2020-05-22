Query mSeenRef = db.child("Messages").child(MessageSenderId).child(MessageRecieverId).orderByChild("Seen").equalTo(true);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int count = 0;
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            count = count + 1;
        }
        Log.d(TAG, String.valueOf(count)); //Will print the number of seen messages
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
mSeenRef.addListenerForSingleValueEvent(valueEventListener);