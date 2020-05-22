@ManagedBean
@RequestScoped
public class Articles {

    @ManagedProperty(value="#{user}")
    private UserManager user;

    public UserManager getUser() {
        return user;
    }

    public void setUser(UserManager user) {
        this.user = user;
    }

}