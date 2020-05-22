public class MyTelephones {

    @Property
    @SessionState
    private User user;

    @Property
    private Telephone telephone;

    @Property
    @Inject
    private UserDataAccess userDataAccess;

    public List<Telephone> getShowTelephones() {
        return userDataAccess.getUsersTelephones(user.getName());
    }