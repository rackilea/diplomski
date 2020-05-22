Map<String, Object> map = new HashMap<>();
map.put("noOfLikes", 0);
map.put("commentId", commentId);
rootRef
    .child(UserId)
    .child(PhotoId)
    .child("comments")
    .child(commentId)
    .updateChildren(map);