databaseReference=mFirebaseDatabase.getReference("Users");              
firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
databaseReference
    .child(firebaseUser.getUid())
    .orderByChild("favourites")
    .addListenerForSingleValueEvent(/* ... */);