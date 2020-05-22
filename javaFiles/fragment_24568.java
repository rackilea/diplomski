DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
FirebaseAuth auth     = FirebaseAuth.getInstance();
FirebaseUser user     = auth.getCurrentUser();

ref.child(user.getUid()).child("name").setValue("Darryl Fernand");
ref.child(user.getUid()).child("email").setValue("fernsdarryyl@gmail.com");
ref.child(user.getUid()).child("gender").setValue("male");