@NoRepositoryBean
public interface CustomRepository<[Your object]> {
    List<Object[]> methodThatQueriesMultipleTables();
}

public class MyRepositoryImpl<[Your object]> implements CustomRepository<[Your object] {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> methodThatQueriesMultipleTables() {
        //use JPA query to select columns from different tables
        Query nativeQuery = entityManager.createNativeQuery("query");
        return query.getResultList();
    }
}