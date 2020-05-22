@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-junit.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS) //otherwise mariadb is not cleaned up between tests
public abstract class MyIntegrationTest {

    private static MariaDB4jSpringService DB;

    @BeforeClass
    public static void init() throws ManagedProcessException {
        DB = new MariaDB4jSpringService();
        DB.setDefaultPort(1234);
        DB.start();
        DB.getDB().createDB("yourtables");
        DB.getDB().source("schema.sql"); // init scripts from /src/test/resources/schema.sql
    }

    @AfterClass
    public static void cleanup() {
        if (DB != null) DB.stop();
    }
}