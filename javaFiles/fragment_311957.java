DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance()
                .getReference();
DatabaseReference mRef = mDatabaseReference.child("order")

node.limitToLast(2).orderByChild("timestamp")
                   .addValueEventListener(mValueEventListener);

private ValueEventListener mTypingValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
            Log.i(TAG, "onDataChange: " + snapshot.getValue());
            // Your code
        }

        @Override
        public void onCancelled(DatabaseError error) {
            Log.w(TAG, "onCancelled: " + error.getMessage());
        }
    };