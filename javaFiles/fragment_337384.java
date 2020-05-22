String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference postsRef = rootRef.child("users").child(uid).child("posts");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String postId = ds.getKey();

            DatabaseReference postIdRef = rootRef.child("posts").child(postId);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
                        String postName = dSnapshot.child("postName").getValue(String.class);
                        Log.d("TAG", postName);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            };
            postIdRef.addListenerForSingleValueEvent(eventListener);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
postsRef.addListenerForSingleValueEvent(valueEventListener);