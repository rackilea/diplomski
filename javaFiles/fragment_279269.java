@Service
    public class UserServiceImpl implements UserService<User, Integer>, Serializable {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
   //other methods
}