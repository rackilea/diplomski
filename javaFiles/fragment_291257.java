DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
String the_uid = user.getUid();
DatabaseReference additionalUserInfoRef = rootRef.child("UserRegistraion").child(the_uid);
ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String userName = dataSnapshot.child("username").getValue(String.class);
            String userMail = dataSnapshot.child("e-mail").getValue(String.class);
            String nameOfUser = dataSnapshot.child("name").getValue(String.class);
        }
    }