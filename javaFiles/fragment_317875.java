public class RetryTest {
  @Rule
  public Retry retry = new Retry(3);

  @Before
  public void before() {
    System.err.println("before");
  }

  @Test
  public void test1() {
  }

  @Test
  public void test2() {
      Object o = null;
      o.equals("foo");
  }
}