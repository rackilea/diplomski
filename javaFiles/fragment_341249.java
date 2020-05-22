@ManagedBean
public class Bean {

    private User user // +getter

    @EJB
    private UserService userService;

    public void login() {
        if (userService.find(user) != null) {
            // Login.
        }
    }

    // ...
}