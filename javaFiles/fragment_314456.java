DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("tags");
ref.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
     for(DataSnapshot datas: dataSnapshot.getChildren()){
          String classnames=datas.getKey();

            }
       }
     @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});