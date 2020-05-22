public class TestClass {

  private static SomeConnection connection;

  @BeforeClass
  public static void setUp() {
    //do common setup
    connection = new SomeConnection();
  }

  @Test
  public void testSomething() { }

  @Test
  public void testSomethingElse() { }

  @AfterClass
  public static void tearDown() {
    //do teardown operations
    connection.close();
  }

}