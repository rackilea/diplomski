@Repository("userDao")
public class UserDaoImpl implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    // the HQL queries

}