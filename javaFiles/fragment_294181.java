mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("users").child(user_id);
 mDatabaseUsers.addValueEventListener(new ValueEventListener(){
 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
  String names=dataSnapshot.child("name").getValue().toString();
  String images=dataSnapshot.child("image").getValue().toString();
   Glide.with(ActivityNameHere.this).load(images).into(mSetupImageBtn);
   mNameField.setText(names);
 }

 @Override
public void onCancelled(FirebaseError firebaseError) {


 }
});