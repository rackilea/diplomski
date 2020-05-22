String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference usersRef = rootRef.child("users").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String name = dataSnapshot.child("name").getValue(String.class);
        tName.setText(name);
        String email = dataSnapshot.child("email").getValue(String.class);
        tEmail.setText(email);
        Log.d("TAG", name + " / " + email);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
uidRef.addListenerForSingleValueEvent(valueEventListener);