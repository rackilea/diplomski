@Bean
public SessionFactory sessionFactory() {
    EmbeddedDriver driver = new EmbeddedDriver(graphDatabaseService());
    return new SessionFactory(driver, "org.neo4j.boot.test.domain");
}

@Bean
public PlatformTransactionManager transactionManager() {
    return new Neo4jTransactionManager(sessionFactory());
}

@Bean
public GraphDatabaseService graphDatabaseService() {
    return new TestGraphDatabaseFactory().newImpermanentDatabaseBuilder().newGraphDatabase();
}

@Bean
public GraphAwareRuntime graphAwareRuntime() {
    ...