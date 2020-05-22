DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        Query query = reference.orderByChild("chat_id").equalTo("CHAT_ID_To_COMPARE");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot issue : dataSnapshot.getChildren()) {
                        // do something with the individual object
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });