import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DividerTest {

  private int dividend;
  private int divisor;
  private int expectedResult;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    Object[] test1 = { 10, 5, 2 };
    Object[] test2 = { 15, 5, 3 };
    Object[] test3 = { 20, 5, 5 };

    return Arrays.asList(test1, test2, test3);
  }

  public DividerTest(int dividend, int divisor, int expectedResult) {
    this.dividend = dividend;
    this.divisor = divisor;
    this.expectedResult = expectedResult;
  }

  @Test
  public void testDivider() {
    assertEquals(expectedResult, dividend / divisor);
  }
}