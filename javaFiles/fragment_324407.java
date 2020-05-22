mDatabase.child("answers").child(num).addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot) {
            String option = dataSnapshot.getValue().toString();
            options.add(option);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });