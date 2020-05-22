@SessionScoped
public class SessionAuthListener implements Serializable {

    private static final long serialVersionUID = 1L;

    public void onAuthenticated(@Observes AuthenticatedEvent event) {
        String username = event.getUserPrincipal().getName();
        // Do something with name, e.g. audit, 
        // load User instance into session, etc
    }

    public void onLoggedOut(@Observes LoggedOutEvent event) {
        // take some action, e.g. audit, null out User, etc
    }
}