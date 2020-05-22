public class PostManager {

    private ArrayList<Post> postList;

    public PostManager() {
        this.postList = new ArrayList<Post>();
    }

    public void addPost(Post newPost) {
        this.postList.add(newPost);
    }

    public ArrayList<Post> getPosts(){
        return this.postList;
    }

}