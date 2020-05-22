public class TestClass extends AbstractTransactionalSpringJUnit4ContextTests {

    private TestRepository repo; 

 @Test
 public void testSave() {
    int rowCount = countRowsInTable("your-table-name");
    repo.save(yourEntity);
    repo.flush(); 
    int rowCountAfter = countRowsInTable("your-table-name");
    assertTrue(rowCountAfter - rowCount == 1); // Or whatever you like to verify the row was added 
 }