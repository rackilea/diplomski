public static void checkIfBookmarked(final String title, callbackFunction){
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    final DatabaseReference userBookmarks = FirebaseDatabase.getInstance().getReference().child("users")
            .child(user.getUid()).child("bookmarks");
    final boolean[] exists = new boolean[1];
    userBookmarks.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            exists[0] = dataSnapshot.child(title).exists() ;
            //execute your callback function here
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
    return;
}