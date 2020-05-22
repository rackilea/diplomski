conversations {
  _id: ObjectId,
  whatever fields you need,
}
comments {
  _id: ObjectId,
  parentId: ObjectId,
  conversationId: ObjectId,
  authorId: ObjectID,
  commentText: String,
  lft: Int,
  rght: Int,
  ...
}