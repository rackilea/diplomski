public class TestClass {

  private String testString;

  public TestClass(String testString) {
    this.testString = Objects.requireNonNull(testString);
  }

}