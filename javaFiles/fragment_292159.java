FirebaseUser users;
if(task.isSuccessful()){

   users= task.getResult().getUser();
   DatabaseReference ref = mData.child(users.getUid());
   ref.child("name").setValue(name);
   ref.child("phone").setValue(phone);