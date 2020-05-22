public class TestClass {
  /**
   * The value of this constant is {@value}.
   */
  // In Eclipse this shows: The value of this constant is "<script>".
  public static final String SCRIPT_START = "<script>";
  /**
   * Evaluates the script starting with {@value TestClass#SCRIPT_START}.
   */
  // In Eclipse this shows: Evaluates the script starting with {@value TestClass#SCRIPT_START}.
  public void test1() {
  /**
   * Evaluates the script starting with {@value #SCRIPT_START}.
   */
  // In Eclipse this shows: Evaluates the script starting with "<script>".
  public void test2() {
  }
}