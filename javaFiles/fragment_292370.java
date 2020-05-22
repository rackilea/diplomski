@Named
@RequestScoped //this depends on your use case
public UserBean {

    @Inject
    private UserDao dao;

    public void addUser(User user) {
        dao.addUser(user);
    }
}