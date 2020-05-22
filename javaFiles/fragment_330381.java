// Note: No annotation required at this class definition.
public class PostWithComments {
   @Embedded
   public Post post;

   @Relation(parentColumn = "id", entityColumn = "postId", entity = Comment.class)
   public List<Comment> comments;
}