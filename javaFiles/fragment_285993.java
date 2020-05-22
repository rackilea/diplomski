public class User {
    private long userId;
    private String userName; 
    private Set<ForumPost> forumPosts;
}

public class ForumPost {
    private long postId;
    private User user; 
    private String content;
}