@Configuration
@PropertySource("classpath:persistence-${envTarget:default}.properties")
@EnableJpaRepositories(basePackages = {"dk.fitfit.campusfood.model", "dk.fitfit.campusfood.repository"})
public class PersistenceConfig {
    private static final Logger logger = LoggerFactory.getLogger(PersistenceConfig.class);

    @Autowired
    private DataInitializer dataInitializer;

    @Autowired
    private Environment env;

    private final String packagesToScan = "dk.fitfit.campusfood";


    public PersistenceConfig() {
        logger.info("PersistenceConfig loaded!");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan(packagesToScan);
        factory.setJpaVendorAdapter(jpaVendorAdapter());
        return factory;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabasePlatform( env.getRequiredProperty("jdbc.hibernate.dialect"));
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Profile("!openshift")
    @Configuration 
    public static class DefaultPersistenceConfig { 
        @Bean 
        public DataSource dataSource() { 
            return new EmbeddedDatabaseBuilder() 
            .setType(EmbeddedDatabaseType.H2) 
            .build(); 
        }
    }

    // Activate this profile on openshift by running: rhc set-env JAVA_OPTS_EXT=-Dspring.profiles.active=openshift -a campusfood
    @Configuration
    @Profile("openshift")
    public static class OpenShiftPersistenceConfig {
        private static final Logger logger = LoggerFactory.getLogger(OpenShiftPersistenceConfig.class);

        private String driverClassName = "org.postgresql.Driver";
        private String database = "campusfood";
        private String url = System.getenv("OPENSHIFT_POSTGRESQL_DB_URL") + "/" + database;

        @PostConstruct
        public void postConstructor()t
        {
            logger.info("OpenShiftPersistenceConfig loaded!");
        }

        @Bean
        public DataSource dataSource()
        {
            logger.info("dataSource()");
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            return dataSource;
        }
    }
}