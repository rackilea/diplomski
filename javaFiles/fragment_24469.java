DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference userNameRef = rootRef.child("Users").child("Nick123");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(!dataSnapshot.exists()) {
            //create new user
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
userNameRef.addListenerForSingleValueEvent(eventListener);