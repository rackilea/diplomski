@Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new com.mchange.v2.c3p0.ComboPooledDataSource();
        try {
            JndiTemplate jndiTemplate = new JndiTemplate();
            dataSource = (DataSource)jndiTemplate.lookup("java:comp/env/jdbc/JCGExampleDB");
            } catch (NamingException e) {
            log.error("Unable to configure datasource: " + e.getStackTrace());
        }
        return dataSource;
    }