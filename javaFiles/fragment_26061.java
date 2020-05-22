@Service
public class (className)Impl implements (className)Custom{

@PersistenceContext
private EntityManager entityManager;

@Override
public List<Person> findUserFromLocus() {
    String query = "select * from Person";
    return entityManager.createQuery(query).getResultList();
    }

}