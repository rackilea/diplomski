public class TestWatcherTest {
  @Rule
  public TestWatcher testWatcher = new TestWatcher() {
    protected void failed(Throwable e, Description description) {
      System.out.println("" + description.getDisplayName() + " failed " + e.getMessage());
      super.failed(e, description);
    }

  };

  @Test
  public void test1() {
    Assert.assertEquals("hello world", 3, 4);
  }
}