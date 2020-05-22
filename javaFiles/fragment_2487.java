public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public User validateUser(Login login) {
        return userDao.validateUser(login);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}