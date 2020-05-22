@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"username", "password"}
)
@XmlRootElement(
        name = "Login",
        namespace = "http://example.org/test_Service"
)
public class Login {
    protected String username;
    protected String password;

    public Login() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password = value;
    }
}