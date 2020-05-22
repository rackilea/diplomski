DatabaseReference reference = FirebaseDatabase.getInstance().getReference("streams");

reference.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
   String hosts=datas.child("host").getValue().toString();
   String medias=datas.child("media").getValue().toString();
   String metadata=datas.child("metadata").getValue().toString();
   String ports=datas.child("port").getValue().toString();
   String protocol=datas.child("protocol").getValue().toString();
   String steamname=datas.child("streamName").getValue().toString();


 }
@Override
 public void onCancelled(DatabaseError databaseError) {
  }
 });