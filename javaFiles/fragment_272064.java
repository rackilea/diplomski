@SqlConfig(dataSource = TestDataSourceConfig.SCHEMA_DATA_SOURCE, transactionManager = SCHEMA_TRANSACTION_MANAGER, transactionMode = SqlConfig.TransactionMode.ISOLATED)
...
public class MyJUnitTest {
  @PersistenceContext(unitName = "pu")
  private EntityManager em;
  ...

  @Test
  @Sql(statements = {"SOME SQL USING THE PRIVILEGED SCHEMA CONNECTION"}, ...)
  public void myTest() {
    em.createQuery("...").getResultList() // uses the APP database user. 
  }
}