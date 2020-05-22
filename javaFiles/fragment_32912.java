@ActiveProfiles(Profiles.PROFILE_TEST)
    @Testcontainers
    @SpringJUnitWebConfig
    @AutoConfigureMockMvc
    @SpringBootTest(classes = Application.class)
    @ContextConfiguration(initializers = {IntegrationTest.Initializer.class})
    public abstract class IntegrationTest {

        private static final MSSQLServerContainer mssqlContainer;

        //added this
        private static final AtomicBoolean initDB = new AtomicBoolean(true);

        static {
            mssqlContainer = new MSSQLServerContainer()
                    .withInitScript("setup.sql"); //Creates users/permissions etc
            mssqlContainer.start();
        }

        static class Initializer implements ApplicationContextInitializer {

            @Override
            public void initialize(final ConfigurableApplicationContext configurableApplicationContext) {
                TestPropertyValues.of(
                    "spring.datasource.url=" + mssqlContainer.getJdbcUrl(),

                    //added this
                    "spring.datasource.initialization-mode=" + (initDB.get() ? "always" : "never"))
                .applyTo(configurableApplicationContext.getEnvironment());

                //added this
                initDB.set(false);
            }
        }
    }