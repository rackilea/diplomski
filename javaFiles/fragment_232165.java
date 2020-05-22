@ApiMethod(name = "getPostComments")
public List<CommentResults> getPostComments(@Named("postId") Long postId) {
EntityManager mgr = getEntityManager();
List<CommentResults> results = new ArrayList<Comment>();
try {
    Post p = mgr.find(Post.class, postId);
    if (p == null) {

        throw new EntityNotFoundException("Post does not exist");

    } else {
        for(Comment c:p.getComments()){    //copying the data
            CommentResults cr = new CommentResults();
            cr.setMessage(c.getMessage);
            cr.setUserId(c.getUserId);
            results.add(cr);
        }
    }

} finally {
    mgr.close();
}

return results;
}