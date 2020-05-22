private DatabaseReference mDatabase;

mDatabase = FirebaseDatabase.getInstance().getReference();


private void writeNewPost(String postId, String post, String postOwner) {
    Post post = new Post(post, postId, postOwner);

    mDatabase.child("posts").child(postId).setValue(post);
}