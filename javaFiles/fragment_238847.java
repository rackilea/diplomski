import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

public class MyTest {
  @Rule
  public TestMethodLogging rule = new TestMethodLogging();

  @Test
  public void sumOfTwoInts() throws Throwable {
    rule.getLogger().error(
        "logging to a logger whose name is based on the test method's name");
    assertEquals(5, 2 + 3);
  }

  @Test
  public void productOfTwoInts() throws Throwable {
    rule.getLogger().error(
        "logging to a logger whose name is based on the test method's name");
    assertEquals(8, 2 * 4);
  }
}