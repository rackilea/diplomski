public class TestCaseExample {
  @Rule
  public TestName testName = new TestName();

  @Before
  public void setUp() {
    Method m = TestCaseExample.class.getMethod(testName.getMethodName());       
    ...
  }
  ...