@Bean
    @Primary
    @ConfigurationProperties("app.datasource.foo")
    public DataSourceProperties fooDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.foo")
    public DataSource fooDataSource() {
        return fooDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("app.datasource.bar")
    public BasicDataSource barDataSource() {
        return (BasicDataSource) DataSourceBuilder.create()
                .type(BasicDataSource.class).build();
    }