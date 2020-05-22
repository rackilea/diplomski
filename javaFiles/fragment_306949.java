DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");

reference.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
  for(DataSnapshot datas: dataSnapshot.getChildren()){
     DataSnapshot ds=datas.child("books");
     for (DataSnapshot dsBook: ds.getChildren()) {
      String bookName=dsBook.child("book_Name").getValue().toString();
    }
 }
  @Override
public void onCancelled(DatabaseError databaseError) {
      }
   });