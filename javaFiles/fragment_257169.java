public class UserWrapper implements Serializable {

    private User user;

    public UserWrapper(User user) {
        this.user = user;
    }

    public User get() {
        return user;
    }

}