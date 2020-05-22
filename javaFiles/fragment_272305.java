DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

ref.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
  for(DataSnapshot datas: dataSnapshot.getChildren()){
     String messages = datas.child("message").getValue().toString();
     }
 }
@Override
public void onCancelled(DatabaseError databaseError) {
     }
});