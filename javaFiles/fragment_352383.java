/**
 * Utility class for simplifying access to the instance of async service.
 */
public static class Util {
    private static UserServiceAsync instance;
    public static UserServiceAsync getInstance(){
        if (instance == null) {
            instance = GWT.create(UserService.class);
        }
        return instance;
    }
}