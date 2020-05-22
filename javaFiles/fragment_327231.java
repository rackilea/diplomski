ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnapshot data : dataSnapshot.getChildren()){
     String retrieveposts=data.child("posts").getValue().toString();
    }
    }