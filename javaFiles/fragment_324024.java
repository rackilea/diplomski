@RunWith(Cucumber.class)
@Cucumber.Options(
    features = "test/resources/cucumber",
    format = "html:target/cucumber"
)
public class RunTests {
    private static Configuration configuration;
    String url = "test-db-url";
    String user = "user";
    String pass = "pass";

    @BeforeClass
    public static void preparaBase() {
        // gets the mapped configuration to the db
        configuration = HibernateUtil.getConfiguration();

        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", user);
        configuration.setProperty("hibernate.connection.password", pass);

        // rebuilds the configuration using my test database
        HibernateUtil.rebuildSessionFactory(configuration);

        // executes a script stored in test/resources/cucumber
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            ScriptRunner runner = new ScriptRunner(conn, false, true);

            runner.runScript(new BufferedReader(new FileReader("test/resources/cucumber/db.sql")));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}