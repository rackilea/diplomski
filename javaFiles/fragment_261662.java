db.addValueEventListener(new ValueEventListener(){
@Override
    public void onDataChange(DataSnapshot dataSnapshot) {
      for(DataSnapshot data: dataSnapshot.getChildren()){
          String messagebody=data.child("messagebody").getValue().toString();
          String messageauthor=data.child("messageauthor").getValue().toString();
          String messagetime=data.child("messagetime").getValue().toString();
        }
      }

    @Override
    public void onCancelled(DatabaseError databaseError) {
    }
};);