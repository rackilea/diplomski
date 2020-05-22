public class UserModel implements Serializable {
    private String userEmail;
    private String userName;

    public UserModel() {}

    public UserModel(String userEmail, String userName) {
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public String getUserEmail() {return userEmail;}
    public String getUserName() {return userName;}
}