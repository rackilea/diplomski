@Stateless
public class JPAUserDAO extends JPABaseDAO<User> implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllAuthorized() {
        return entityManager.createNamedQuery("User.getAllAuthorized", User.class)
                            .getResultList();
    }
}