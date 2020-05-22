mref = FirebaseDatabase.getInstance().getReference("user").child(USER_ID).child("likes");
mref.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
    String likes = dataSnapshot.getValue(String.class);
    //do what you want with the likes
 }

 @Override
 public void onCancelled(DatabaseError databaseError) {

 }
});