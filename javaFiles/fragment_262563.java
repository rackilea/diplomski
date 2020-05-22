public class AddUserAction extends ActionSupport implements ModelDriven<User> {

    private static final long serialVersionUID = 4587665276501838677L;

    private User user;

    @Override
    public String execute() throws Exception {
        // Here you will find your user object populated with form fields
        userDao.saveUser(user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}