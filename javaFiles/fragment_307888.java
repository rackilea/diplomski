// Answer class
public class Answer {

    private final User user;

    public Answer(final User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

// User class
public class User implements Comparable<User> {

    private final int points;

    public User(final int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public int compareTo(User other) {
        // Sort user by their points (ascending order)
        return points - other.points;
    }

    @Override
    public String toString() {
        return "User{" + "points=" + points + '}';
    }
}