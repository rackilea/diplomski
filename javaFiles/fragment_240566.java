DatabaseReference db_receipt =FirebaseDatabase.getInstance().getReference().child("users").child(uid).child("Receipt")
long sum = 0;
db_receipt.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot ds:dataSnapshot.getChildren()
                    ) {
                        sum = sum + points;
                        }

                }
            }


        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });