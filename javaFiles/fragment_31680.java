public DataSource getPrimaryDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(...);
    dataSource.setUrl(...);
    dataSource.setUsername(...);
    dataSource.setPassword(...);
    dataSource.setValidationQuery(...);
    return dataSource;
}

public DataSource getSecondaryDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(...);
    dataSource.setUrl(...);
    dataSource.setUsername(...);
    dataSource.setPassword(...);
    dataSource.setValidationQuery(....);
}