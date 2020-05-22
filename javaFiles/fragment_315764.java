public interface UserRepository extends CrudRepository<User, Long>, CustomUserRepository {};

public interface CustomUserRepository {
    User doComplexQuery();
};

public class CustomUserRepositoryImpl implements UserRepository {

    @Autowired
    EntityManager em;

    public User doComplexQuery() {

        List<Result> rows = em.createNativeQuery("select * from ... ");
        User user = new User(rows.get(0));
        return user;

    }
};