mUsers = FirebaseDatabase.getInstance().getReference().child("users");
Query allAvailable = mUsers.orderByChild("available").equalTo("true");

reference.addValueEventListener(new ValueEventListener() {
  @Override
public void onDataChange(DataSnapshot dataSnapshot) {
     long xy = dataSnapshot.getChildrenCount();
}
  @Override
public void onCancelled(DatabaseError databaseError) {
  }
});