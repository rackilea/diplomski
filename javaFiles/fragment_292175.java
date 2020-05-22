public interface UserFactoryListener {
    public void userCreated(User user);
    public void userCreationFailed(Exception exp); // Or some other error object
}

public interface UserFactory {
    public void makeUser(String name);

    public void addUserFactoryListener(UserFactoryListener listener);
    public void removeUserFactoryListener(UserFactoryListener listener);
}