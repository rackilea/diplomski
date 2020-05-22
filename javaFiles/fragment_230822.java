@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class LoginRequest extends AbstractDto{

    @NotNull
    private String userName;

    @NotNull
    private String password;

    private LoginRequest() {
    }

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}