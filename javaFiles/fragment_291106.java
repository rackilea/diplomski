@ManagedBean(name="accessBacking")
@SessionScoped
public class AccessBacking {
    private String username;
    private String password;

    public boolean checkViewAccess() {
        Access access = new Access();
        if(access.authenticate(username, password)) {
          // user is logged in  
        }
    }
}