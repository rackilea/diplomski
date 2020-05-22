Query sqlite = mDatabaseReference.child("Messages").child(MessageSenderId).child(MessageRecieverId);
sqlite.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

for (DataSnapshot vinSnapshot : dataSnapshot.getChildren()) {
                    if (vinSnapshot .hasChild("Message")) {
                    String msg = dataSnapshot.child("Message").getValue().toString();
                    String from = dataSnapshot.child("From").getValue().toString();
                    String time = dataSnapshot.child("Time").getValue().toString();

                } else {
                    Toast.makeText(getApplicationContext(), "NULLLL", Toast.LENGTH_SHORT).show();
                }
                }