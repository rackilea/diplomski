private final List<Post> posts;

public  Wall(List<Post> posts) {
    this.posts = Collections.synchronizedList(new ArrayList<>(posts));
}

public void addPost(Post post) {
    posts.add(post); // internally synchronized
}

public List<Post> getPosts() {
    return Collections.unmodifiableList(post);
}