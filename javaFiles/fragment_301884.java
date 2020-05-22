@Repository("userDao")
public class UserDao implements UserInterface {
    //methods
}


@Service
public class UserService {

    @Autowired
    @Qualifier("userDao")
    UserDao userDao;

    //methods
}