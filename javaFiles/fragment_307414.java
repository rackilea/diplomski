@Service
public final class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private transient UserDAO userDAO;

    public User findUser(final Long id) {
        return userDAO.find(id);
    }

}