public class Post extends DatabaseObject<Post> {

    //The column names
    public final static String POST_ID = "PostID";
    public final static String CONTENT = "Content";
    public final static String AUTHOR = "Author";

    public Post() {
        //Define default values
    }

    public int getPostId() {
        return (Integer)get(POST_ID);
    }
    public void setPostId(int id) {
        put(POST_ID, id);
    }
    public String getContent() {
        return (String)get(CONTENT);
    }
    public void setContent(String content) {
        put(CONTENT, content);
    }
    public String getAuthor() {
        return (String)getAuthor();
    }
    public void setAuthor(String author) {
        put(AUTHOR, author);
    }

    @Override
    public String getTableName() {
        return "myschema.posts";
    }

}