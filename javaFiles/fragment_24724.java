public class PersistenceManager {

    private static EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("pers-unit"); // defined in a persistence.xml
    }

    public static EntityManager getEntityManager() {
       return emFactory.createEntityManager();
    }

    public static void close() {
        emFactory.close();
    }
}