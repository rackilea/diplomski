public class RetrieveResultList {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("EntityLibraryPU");

    public static <T> List<T> retrieveResultList(Class<T> type) {
        EntityManager entityManager = FACTORY.createEntityManager();
        String tablename = type.getName(); // figure out table name from **type**
        Query query = entityManager.createNamedQuery(tablename + ".findAll");
        List<T> resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }
}