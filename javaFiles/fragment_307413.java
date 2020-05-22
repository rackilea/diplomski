@Repository
public final class UserDAO extends AbstractDAO<User, Long> {

    @Autowired
    private transient EntityManagerFactory emf;

    public UserDAO() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // particular methods for this DAO

}