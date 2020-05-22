public void sendFriendRequest(final String userID){
    mDatabase.child("Users").child(uniqueUserID).child("username").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshotTwo) {
            String currentUserName = dataSnapshotTwo.getValue(String.class);
            Log.d("TAG", currentUserName);
        }

        @Override
        public void onCancelled(DatabaseError firebaseError) {
            Log.e("MainActivity", "onCancelled", firebaseError.toException());
        }
    });
}