public final class EntityManagerFactoryCreator {
    private static DataSource getDataSource(String properties) {
        Properties conf = new Properties();
        try {
            conf.load(
                DataSourceFactory.class
                .getClassLoader().getResourceAsStream(
                    properties));
        } catch (IOException e) {
            //handle the error
            //naive handling shown here
            e.printStacktrace();
        }
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(conf.getProperty("db.driver"));
        dataSource.setJdbcUrl(conf.getProperty("db.url"));
        dataSource.setUsername(conf.getProperty("db.user"));
        dataSource.setPassword(conf.getProperty("db.password"));
        dataSource.setIdleConnectionTestPeriodInMinutes(
            Long.parseLong(
                conf.getProperty("db.bonecp.idleConnectionTestPeriod")));
        dataSource.setIdleMaxAgeInSeconds(
            Long.parseLong(
                conf.getProperty("db.bonecp.idleMaxAge")));
        dataSource.setMaxConnectionsPerPartition(
            Integer.parseInt(
                conf.getProperty("db.bonecp.maxConnections")));
        //more properties to load...
        return dataSource;
    }

    public static EntityManagerFactory createEMF() {
        Map<String, Object> properties = new HashMap<>();
        String dataSourceKey = "";
        //using Hibernate
        //dataSourceKey = org.hibernate.cfg.AvailableSettings.DATASOURCE;
        //using EclipseLink
        //dataSourceKey = org.eclipse.persistence
        //    .config.PersistenceUnitProperties.NON_JTA_DATASOURCE;
        properties.put(
            dataSourceKey,
            getDataSource("mysql-con.properties"));
        return Persistence.createEntityManagerFactory("foo-PU", properties);
    }
}