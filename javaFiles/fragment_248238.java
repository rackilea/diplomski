public class InnerTest {
    public String id;
    public UserType user = new UserType();
    static class UserType {
        String userName;
        String userID;
    }
}