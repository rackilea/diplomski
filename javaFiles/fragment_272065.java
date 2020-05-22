@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties(JpaProperties.class)
public class TestDataSourceConfig {

    public static final String SCHEMA_DATA_SOURCE = "schemaDS";
    public static final String SCHEMA_TRANSACTION_MANAGER = "schemaTM";
    public static final String SCHEMA_EMF = "schemaEMF";

    /*Main Datasource and supporting beans*/

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }

    @Bean @Primary @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) { return new JpaTransactionManager(emf); }

    @Bean @Primary
    public LocalContainerEntityManagerFactoryBean emfBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            DataSource datasource,
            JpaProperties jpaProperties) {
        return entityManagerFactoryBuilder
                .dataSource(datasource)
                .jta(false)
                .packages(CourseOffering.class)
                .persistenceUnit("pu")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = SCHEMA_EMF)
    public LocalContainerEntityManagerFactoryBean emfSchemaBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier(SCHEMA_DATA_SOURCE) DataSource schemaDataSource,
            JpaProperties jpaProperties) {
        return entityManagerFactoryBuilder
                .dataSource(schemaDataSource)
                .jta(false)
                .packages(CourseOffering.class)
                .persistenceUnit("spu")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = SCHEMA_DATA_SOURCE)
    @ConfigurationProperties(prefix = "myapp.datasource.test_schema")
    public DataSource schemaDataSource() { return new DriverManagerDataSource(); }

    @Bean(name = SCHEMA_TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManagerSchema(
            @Qualifier(SCHEMA_EMF) EntityManagerFactory emfSchemaBean) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emfSchemaBean);
        return jpaTransactionManager;
    }
}