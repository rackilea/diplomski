public class AuthUserInfo extends Auth {

    UserInfo sessionId;

    public AuthUserInfo(String email, String password) {
        this.sessionId = new UserInfo(email, password);
    }

    static class UserInfo {
        String email;
        String password;

        public UserInfo(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }
}