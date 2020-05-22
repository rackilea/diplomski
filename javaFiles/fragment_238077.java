public enum UserFactory implements IUserFactory {
    INSTANCE;

    private Map<String, User> map = new ConcurrentHashMap<>();

    @Override
    public User getUser(String username) {

        User user = map.get(username);
        if (user != null) {
            return user;
        }
        synchronized (INSTANCE) {
            final User user = new User(username);
            map.put(username, user);
            return user;
        }

    }

}