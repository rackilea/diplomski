FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
String useruid=user.getUid();
DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("user").child(useruid).child("requests");
ref.addChildEventListener(new ChildEventListener() {

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        String subject=dataSnapshot.child("subject").getValue().toString();
        String time=dataSnapshot.child("time").getValue().toString();

    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {


    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

  };