mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);

mUserDatabase.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String keys=dataSnapshot.getKey();
            String displayname=dataSnapshot.child("name").getValue().toString();

            mName.setText(displayname);
    }}

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }  
 });