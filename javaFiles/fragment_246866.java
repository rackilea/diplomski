DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

reference.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnapshot datas: dataSnapshot.getChildren()){
      String names=datas.child("name").getValue().toString();
     }
  }
 @Override
public void onCancelled(DatabaseError databaseError) {
     }
});