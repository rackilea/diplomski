@RunWith(Suite.class)
@SuiteClasses({ ExpectedFailureTest.class, RetryTest.class })
public class BeforeClassSuite {
  @BeforeClass
  public static void beforeClass() {
    System.out.println("beforeClass");
  }

  @AfterClass
  public static void afterClass() {
    System.out.println("afterClass");
  }

  @ClassRule
  public static ExternalResource resource = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      System.out.println("before");
    };

    @Override
    protected void after() {
      System.out.println("after");
    };
  };
}