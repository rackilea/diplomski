@Bean
    @RefreshScope
    public DataSource dataSource() {
        CustomRoutingDataSource customDataSource = new CustomRoutingDataSource();
        ...
        return customDataSource;
    }