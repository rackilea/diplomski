DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("admin").child("classPost");
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnapshot data : dataSnapshot.getChildren()){
     String retrieveposts=data.child("posts").getValue().toString();
    }
    }
 @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});