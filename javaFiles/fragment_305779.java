public class LoginRequestArgs {

    public UserInfo userInformation;

    public LoginRequestArgs(String userEmail, String userPassword) {
        userInformation = new UserInfo(userEmail, userPassword);
    }

    static class UserInfo {
        public String userEmail;
        public String userPassword;

        public UserInfo(String userEmail, String userPassword) {
            this.userEmail = userEmail;
            this.userPassword = userPassword;
        }
    }

    public static LoginRequestArgs fromStringJson(String data) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(data, LoginRequestArgs.class);
        } catch (Exception e) {
            return null;
        }
    }

    public static LoginRequestArgs fromBytesJson(byte[] data) {
        if (data == null)
            return null;
        try {
            String str = new String(data, "utf-8");
            return fromStringJson(str);
        } catch (Exception e) {
            return null;
        }
    }

}