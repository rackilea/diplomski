Query query = FirebaseDatabase.getInstance().getReference().child("example_parent").orderByChild("user_id").equalTo("user_1");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });