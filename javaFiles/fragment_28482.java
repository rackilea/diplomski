import org.junit.Test;
import static org.junit.Assert.*;

public class FunTest {
  @Test
  public void test() {
    // original strings:
    assertEquals(1, Fun.fun("I"));
    assertEquals(2, Fun.fun("A"));
    assertEquals(3, Fun.fun("Z"));
    assertEquals(4, Fun.fun("ABS"));
    assertEquals(5, Fun.fun("IND"));

    // same hash codes, but different strings:
    assertEquals(6, Fun.fun("\0I"));
    assertEquals(6, Fun.fun("\0A"));
    assertEquals(6, Fun.fun("\0Z"));
    assertEquals(6, Fun.fun("\0ABS"));
    assertEquals(6, Fun.fun("\0IND"));

    // distinct hash code to cover default cases of switches
    assertEquals(6, Fun.fun(""));
  }
}