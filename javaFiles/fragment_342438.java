DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
String commentId = rootRef
    .child(UserId)
    .child(PhotoId)
    .child("comments")
    .push()
    .getKey();