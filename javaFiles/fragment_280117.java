public interface UserRepositoryCustom {
    ...
   void detachUser(User u);
    ...
}

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    ...
}

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    ...
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detachUser(User u) {
        entityManager.detach(u);
    }
    ...
}