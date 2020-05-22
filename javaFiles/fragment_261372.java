private static List<FBComment> getCommentFromPost(FacebookClient client, String post_id){
    List<String> comments = new ArrayList<FBComment>();

    Connection<Comment> allComments = client.fetchConnection(post_id+"/comments", Comment.class);
    for(List<Comment> postcomments : allComments){
        for (Comment comment : postcomments){
        long likes     = comment.getLikeCount()==null?(comment.getLikes()==null?0:comment.getLikes()):comment.getLikeCount();
        comments.add(comment.getMessage()+" - "+likes);
        }
    }


    return comments;
}