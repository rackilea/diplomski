@Component
@Primary
public class BasicBatchConfigurer implements BatchConfigurer {

    @Inject
    private PlatformTransactionManager transactionManager;
    @Inject
    private EntityManagerFactory entityManagerFactory;
    @Inject
    private BatchProperties properties;
    @Inject
    private DataSource dataSource;

    private JobRepository jobRepository;
    private JobLauncher jobLauncher;
    private JobExplorer jobExplorer;

    public BasicBatchConfigurer() {
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public BatchProperties getProperties() {
        return properties;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public JobRepository getJobRepository() {
        return jobRepository;
    }

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    public JobExplorer getJobExplorer() {
        return jobExplorer;
    }

    protected JobExplorer createJobExplorer() throws Exception {
        JobExplorerFactoryBean jobExplorerFactoryBean = new JobExplorerFactoryBean();
        jobExplorerFactoryBean.setDataSource(this.dataSource);
        String tablePrefix = this.properties.getTablePrefix();
        if (StringUtils.hasText(tablePrefix)) {
            jobExplorerFactoryBean.setTablePrefix(tablePrefix);
        }
        jobExplorerFactoryBean.afterPropertiesSet();
        return jobExplorerFactoryBean.getObject();
    }

    protected JobLauncher createJobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(getJobRepository());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

    protected JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(this.dataSource);
        if (this.entityManagerFactory != null) {
            factory.setIsolationLevelForCreate("ISOLATION_DEFAULT");
        }
        String tablePrefix = this.properties.getTablePrefix();
        if (StringUtils.hasText(tablePrefix)) {
            factory.setTablePrefix(tablePrefix);
        }
        factory.setTransactionManager(getTransactionManager());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @PostConstruct
    public void initialize() {
        try {
            this.jobRepository = createJobRepository();
            this.jobLauncher = createJobLauncher();
            this.jobExplorer = createJobExplorer();
        }
        catch (Exception ex) {
            throw new IllegalStateException("Unable to initialize Spring Batch", ex);
        }
    }

}