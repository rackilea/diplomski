DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref= rootRef.child("users").child("uid1");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
      String value = dataSnapshot.child("dataKey1").getValue().toString();
      Log.d("TAG", value);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
imageNamesRef.addListenerForSingleValueEvent(eventListener);