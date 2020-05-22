DatabaseReference ref=FirebaseDatabase.getInstance().getReference("Animals");
Query query=ref.orderByChild("category").equalTo("mammal");

 query.addListenerForSingleValueEvent(new ValueEventListener() {
   @Override
public void onDataChange(DataSnapshot dataSnapshot) {
  for(DataSnapshot datas: dataSnapshot.getChildren()){
     String name=datas.child("name").getValue().toString();
    }
  }
   @Override
public void onCancelled(DatabaseError databaseError) {
     }
  });