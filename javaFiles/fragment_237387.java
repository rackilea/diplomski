@Service("userService")
public class UserService2Impl implements IUserService2 {

    private static Map<Integer, User2> users = new HashMap<Integer, User2>();

    static {
        users.put(1, new User2(1, "foo"));
        users.put(2, new User2(2, "bar"));
        users.put(3, new User2(3, "baz"));
    }

    public UserService2Impl() {
    }

    @Override
    public Collection<User2> getUsers() {
        return users.values();
    }

    @Override
    public User2 getUser(Integer id) {
        return users.get(id);
    }

    @Override
    public Response add(User2 user) {
        user.setId(users.size()+1);
        users.put(user.getId(), user);

        //do more stuff to add user to the system..
        return Response.status(Response.Status.OK).build();
    }

}


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("userDao")
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