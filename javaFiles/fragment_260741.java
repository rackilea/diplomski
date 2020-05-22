userTrailsDB.child(userID).child(trialId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               //Do Whatever if exits
            } 


            @Override
            public void onCancelled(DatabaseError error) {

            }
        };