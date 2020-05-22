@PersistenceContext(unitName="sqlserverPU")
private EntityManager sqlserverEntityManager;

public SqlServerQueryDaoImpl(@Qualifier("sqlserverEntityManager")EntityManagerFactory sqlserverEntityManager) {
    this.sqlserverEntityManager = sqlserverEntityManager.createEntityManager();
    session = sqlserverEntityManager.createEntityManager().unwrap(Session.class);
}