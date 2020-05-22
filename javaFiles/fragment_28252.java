public class ExpectedExceptionTest {
  @Test(expected = IOException.class)
  public void test() throws Exception {
    foobar();
  }

  public void foobar() throws IOException {
    try {
      throw new IOException();
    } catch (IOException e) {
      e.printStackTrace(System.err);
      throw e;
    }
  }
}