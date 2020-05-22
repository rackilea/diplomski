@Component
public class TestClass {

  @Autowired(required=true)
  public TestDAO testDAO;

  // When someone calls this method, the testDao component should 
  // be initialized with TestDAO instance.
  public void someMethod(){
    System.out.println("TestClass.testDAO "+testDAO);
  }
} 

public interface TestDAO extends JpaRepository<MyEntity, Long>{
}