@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    public IUserDao userDao;


     public List<User> getCurrentStatuses() {
        return userDao.getAllUsers();
    }

    public void create(User user) {
        userDao.saveOrUpdate(user);
    }

    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();

        if (Objects.isNull(users)) {
            return null;
        }
        return users;
    }
}