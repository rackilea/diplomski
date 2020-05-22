DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
Query query = reference.child("thermometer/Temperature");
query.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                String temp = dataSnapshot.getvalue.toString()    
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
           //display error msg
        }