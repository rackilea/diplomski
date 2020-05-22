public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
}

public class Project {
    private User user1;
    private User user2;
    private int cost;

    public Project(User user1, User user2, int cost) {
        this.user1 = user1;
        this.user2 = user2;
        this.cost = cost;
    }
}