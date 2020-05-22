DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Hospital").orderByChild("location").equalTo(hospitalLocation);
ref.addValueEventListener(new ValueEventListener(){
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
  for(DataSnapshot datas: dataSnapshot.getChildren()){
       String name=datas.child("name").getValue().toString();
       String pin=datas.child("pin").getValue().toString();

   }
 }

  @Override
public void onCancelled(FirebaseError firebaseError) {


  }
});