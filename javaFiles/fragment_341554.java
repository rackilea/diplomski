@Primary
    @Bean(name = "rgDataSource")
    public DataSource rgDataSource()

    @Primary
    @Bean(name = "rgEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("rgDataSource") DataSource dataSource) {