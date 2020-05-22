@Primary
        @Bean
        public DataSource agDataSource() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
            try {
                dataSource.setDriverClass(environment.getRequiredProperty("hibernate.connection.driver_class"));
            } catch (IllegalStateException | PropertyVetoException e) {
                e.printStackTrace();
            }
            dataSource.setJdbcUrl(environment.getRequiredProperty("hibernate.connection.url"));
            dataSource.setUser(environment.getRequiredProperty("hibernate.connection.username"));
            dataSource.setPassword(environment.getRequiredProperty("hibernate.connection.password"));

             dataSource.setMaxPoolSize(Integer.parseInt(environment.getRequiredProperty("hibernate.c3p0.max_size")));
            dataSource.setMinPoolSize(Integer.parseInt(environment.getRequiredProperty("hibernate.c3p0.min_size")));
            dataSource.setMaxIdleTime(Integer.parseInt(environment.getRequiredProperty("hibernate.c3p0.timeout")));
            dataSource.setMaxStatements(Integer.parseInt(environment.getRequiredProperty("hibernate.c3p0.max_statements")));
            dataSource.setIdleConnectionTestPeriod(Integer.parseInt(environment.getRequiredProperty("hibernate.c3p0.idle_test_period")));
            dataSource.setAcquireIncrement(Integer.parseInt(environment.getRequiredProperty("hibernate.c3p0.acquire_increment")));
            dataSource.setPreferredTestQuery(environment.getRequiredProperty("hibernate.c3p0.preferredTestQuery"));
            dataSource.setTestConnectionOnCheckin(true);
            dataSource.setTestConnectionOnCheckout(true);

            return dataSource;
        }