@Dao
 public interface PostCommentsDao {
     //Query
    @Query("SELECT * FROM Post")
    public List<PostWithComments> loadPostWithComments();
 }