public class MyTest {

  @org.junit.Test
  public void test() {
    new Person("foo", "bar");
    assert true;
  }

  @lombok.AllArgsConstructor
  private class Person {
    private String id;
    private String name;
  }
}