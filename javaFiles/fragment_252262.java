DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("Medicines");
    final Query userQuery = rootRef.orderByChild("name").equalTo(textView.getText().toString());

    userQuery.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
   String keys=datas.getKey();
   String class=datas.child("class").getValue().toString();
   String name=datas.child("name").getValue().toString();
  }
 }
    @Override
  public void onCancelled(DatabaseError databaseError) {
  }
  });