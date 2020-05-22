mDatabase.child("events").orderByChild(user).addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
   if(dataSnapshot.exists()){
    for(DataSnapshot snapshot2 : dataSnapshot.getChildren()){
           String keys = snapshot2.getKey();
       }
    }
  }

   @Override
public void onCancelled(@NonNull DatabaseError databaseError) {
  }
});