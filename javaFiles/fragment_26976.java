@Named(name="userUsed")
public class UserOfUserBean {

    @Inject
    @LoggedIn // see answer from jan groth
    private User user;
}