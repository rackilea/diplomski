DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Groups").child(groupUid);

reference.orderByChild("name").equalTo(name_here).addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
public void onDataChange(DataSnapshot dataSnapshot) {
 for(DataSnapshot datas: dataSnapshot.getChildren()){
  String keys=datas.getKey();
   }
}
 @Override
public void onCancelled(DatabaseError databaseError) {
   }
});