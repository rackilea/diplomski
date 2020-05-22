import java.util.ArrayList;
import java.util.List;

public class Venue extends DatabaseObject<Venue> {

    //This is just a key property, not a column
    public final static String POSTS = "Posts";

    public Venue() {
        setPosts(new ArrayList());
    }

    public List<Post> getPosts() {
        return (List<Post>)get(POSTS);
    }
    public void setPosts(List<Post> posts) {
        put(POSTS, posts);
    }
    public void addPost(Post post) {
        getPosts().add(post);
    }

    @Override
    public String getTableName() {
        //Venue doesn't have a table name, it's just a container
        //In your DatabaseObject.save() method, you can specify logic to 
        //account for this condition
        return "";
    }

}