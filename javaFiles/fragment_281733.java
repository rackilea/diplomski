public interface GenericDAO<E, PK extends Serializable> {
    PK save(E newInstance);
    void update(E transientObject);
    //typical dao methods
}

public interface UserDAO extends GenericDAO<User, Long> {
    List<User> findUsersByFirstname(String firstName);
}

@Component
@Transactional
@Repository
@Qualifier("userDAO")
public class UserDAOImpl extends GenericDAOHibernate4<User, Long> 
        implements UserDAO {

    @Autowired
    public UserDAO(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    List<User> findUsersByFirstname(String firstName) {
        //provide implementation here
    }

}

public class UserService extends GenericService<User> {
    @Autowired
    public UserService(@Qualifier("userDAO") UserDAO dao) {
        super(dao);
    }
}