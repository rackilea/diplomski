public abstract class BaseTestWithEntityManager {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    protected EntityTransaction transaction;

    @Before
    public void beforeSuper() {
        transaction = em.getTransaction();
        transaction.begin();
    }

    @After
    public void afterSuper() {
        em.flush();
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }

    @BeforeClass
    public static void beforeClass() {
        emf = Persistence.createEntityManagerFactory("store");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void afterClass() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}