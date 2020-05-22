public class ShutdownExecutionListener extends AbstractTestExecutionListener {
    @Override 
    public void beforeTestClass(TestContext testContext) throwsException {
    }      
    @Override 
    public void afterTestClass(TestContext testContext) throws Exception{
        EmbeddedMysqlDatabase mysqlDB= 
            (EmbeddedMysqlDatabase)testContext.getApplicationContext().getBean(mysqlDB);
        mysqlDB.shutdown();     
    } 
}