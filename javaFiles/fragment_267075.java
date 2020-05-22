final FirebaseAuth auth = FirebaseAuth.getInstance();
    DatabaseReference mDatabase=FirebaseDatabase.getInstance().getReference().child("Users").child(auth.getCurrentUser().getUid());
    mdatabase.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            if(dataSnapshot.hasChild("username")){
                //IT EXISTS
            }
            else{
                //IT DOESNT EXISTS
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });