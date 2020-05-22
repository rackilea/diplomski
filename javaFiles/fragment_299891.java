@Configuration
@ComponentScan(basePackages = {""})
@EnableTransactionManagement
@PropertySources(value = {@PropertySource(value = {"<propertyfile>"})})
public class ModulesConfig {

    private static final Logger log = LoggerFactory.getLogger(ModulesConfig.class);

    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "close")
    public BoneCPDataSource getDataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(environment.getProperty("database.driver"));
        dataSource.setJdbcUrl(environment.getProperty("database.url"));
        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("database.password"));
        dataSource.setIdleConnectionTestPeriodInMinutes(30);
        dataSource.setMaxConnectionsPerPartition(5);
        dataSource.setMinConnectionsPerPartition(2);
        dataSource.setPartitionCount(3);
        dataSource.setAcquireIncrement(2);
        dataSource.setStatementsCacheSize(100);

        return dataSource;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.setProperty("hibernate.showSql", "false");

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPersistenceUnitName("entityManagerFactory");
        em.setPackagesToScan("<packages>");
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(jpaProperties);
        em.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);

        return em;
    }

}