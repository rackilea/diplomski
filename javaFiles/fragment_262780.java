@Component
public class TestClass {

  public TestDAO testDAO;

  @Autowired
  public TestClass(TestDAO testDAO){
   this.testDAO = testDAO;
   System.out.println("TestClass.testDAO "+testDAO);
  }
}