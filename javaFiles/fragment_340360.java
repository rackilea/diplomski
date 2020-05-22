DatabaseReference ref = 
FirebaseDatabase.getInstance().getReference("users");

Firebase user=FirebaseAuth.getInstance().getCurrentUser();

//to send to database
ref.child("uid").setValue(user.getUID());