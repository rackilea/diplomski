String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("Users").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String email = dataSnapshot.child("Email").getValue(String.class);
        String fullName = dataSnapshot.child("FullName").getValue(String.class);
        String password = dataSnapshot.child("Password").getValue(String.class);
        String userName = dataSnapshot.child("Username").getValue(String.class);
        Log.d(TAG, userName);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
uidRef.addListenerForSingleValueEvent(valueEventListener);