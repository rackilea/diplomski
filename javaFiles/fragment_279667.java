public class LoginCredentials {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public LoginCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }
}