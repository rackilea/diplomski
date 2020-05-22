@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
    private User user;
    private String login;
    private String password;

    @PostConstruct
    private void init() {
        this.user = new User();
    }

    public String validate() {
        // Validate given login and password here
        // When user seems to be valid assign it to this.user and return "/someFileForAuthorizedUsers.xhtml";
        this.login = null;
        this.password = null;

        return null;
    }
}