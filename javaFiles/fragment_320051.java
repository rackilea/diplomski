DatabaseReference reference = FirebaseDatabase.getInstance().getReference("inspirational");

reference.addListenerForSingleValueEvent(new ValueEventListener() {
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