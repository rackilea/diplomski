@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Testcontainers
class ITApplicationUserService {

    @Container
    private static final PostgreSQLContainer POSTGRE_SQL_CONTAINER = new PostgreSQLContainer()
            .withDatabaseName("someDatabase")
            .withUsername("someUsername")
            .withPassword("somePassword");

    // EMF for integration tests
    private static EntityManagerFactory emf;

    // EM for tested service
    private static EntityManager entityManager;

    // Tested service
    private static ApplicationUserServiceImpl applicationUserService = new ApplicationUserServiceImpl();

    // Object used for testing
    private static ApplicationUser testingApplicationUser;


    @BeforeAll
    static void init() {

        // Properties for our EMF, which will make EM connected to POSTGRE_SQL_CONTAINER
        Map<String,String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url",POSTGRE_SQL_CONTAINER.getJdbcUrl());
        properties.put("javax.persistence.jdbc.user",POSTGRE_SQL_CONTAINER.getUsername());
        properties.put("javax.persistence.jdbc.password",POSTGRE_SQL_CONTAINER.getPassword());
        properties.put("javax.persistence.jdbc.driver",POSTGRE_SQL_CONTAINER.getDriverClassName());
        properties.put("eclipselink.logging.level","FINE");

        // We need create fresh empty schema in POSTGRE_SQL_CONTAINER
        properties.put("javax.persistence.schema-generation.database.action","create");

        // Creation of EMF
        emf = Persistence.createEntityManagerFactory("integrationTesting",properties);

        // Player for testing
        testingApplicationUser = new ApplicationUser();
        testingApplicationUser.setLogin("loginName");
        testingApplicationUser.setEmail("something@somewhere.com");
        testingApplicationUser.setPassword("123456");
    }

    @Test
    @Order(1)
    void saveNewApplicationUserTest() {
        assertTrue(testingApplicationUser.getId()==null);
        ApplicationUser applicationUser = applicationUserService.saveApplicationUser(testingApplicationUser);
        assertTrue(applicationUser.getId()!=null);
    }

    @Test
    @Order(2)
    void getApplicationUsers() {
        assertTrue(applicationUserService.getAllApplicationUsers().size()==1);
    }


    @BeforeEach
    private void startTransaction() throws IllegalAccessException, NoSuchFieldException {
        entityManager = emf.createEntityManager();
        // We will declare field of EM in tested service
        // EM field in tested class is not public and should not be. We will use reflection for population of EM.
        Field emField = applicationUserService.getClass().getDeclaredField("entityManager");
        emField.setAccessible(true);
        emField.set(applicationUserService,entityManager);

        entityManager.getTransaction().begin();
    }

    @AfterEach
    private void commitTransaction() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
            entityManager.close();
        }

    }

}