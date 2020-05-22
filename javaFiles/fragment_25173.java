DatabaseReference references=FirebaseDatabase.getInstance().getReference().child("user");
references.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot data: dataSnapshot.getChildren()){
           String name=data.child("name").getValue().toString();
           String password=data.child("pass").getValue().toString();
           String img=data.child("img").getValue().toString();

        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});