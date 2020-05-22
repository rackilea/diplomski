import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

public class TestIntsBetween {
  public static int intsBetweenStream(final double num1, final double num2) {
    int below = (int)Math.ceil(num1);
    int above = (int)Math.floor(num2);
    return (int)IntStream.range(below, above)
        .count() + 1;
  }

  public static int intsBetweenStreamCorrect(final double num1, final double num2) {
    int below = (int)Math.ceil(num1);
    int above = (int)Math.floor(num2);
    return below < above
        ?(int)IntStream.range(below, above).count() + 1
        : below == above
          ? 1
          : 0;
  }

  public static int intsBetween(final double num1, final double num2) {
    int below = (int)Math.ceil(num1);
    int above = (int)Math.floor(num2);
    return above - below + 1;
  }

  @Test
  public void try_3_5___4_5 () {
    int actual = intsBetween(3.5, 4.5);
    assertEquals(1, actual);
  }

  @Test
  public void try_2_9___4_1 () {
    int actual = intsBetween(2.9, 4.1);
    assertEquals(2, actual);
  }

  @Test
  public void try_3_0___4_0 () {
    int actual = intsBetween(3.0, 4.0);
    assertEquals(2, actual);
  }

  @Test
  public void try_0_3___0_9 () {
    int actual = intsBetween(0.3, 0.9);
    assertEquals(0, actual);
  }

  @Test
  public void try_165_0___170_0 () {
    int actual = intsBetween(165.0, 170.0);
    assertEquals(6, actual);
  }

  @Test
  public void try_0_0___6_8 () {
    int actual = intsBetween(0.0, 6.8);
    assertEquals(7, actual);
  }

  @Test
  public void try_0_001___0_999 () {
    int actual = intsBetween(0.001, 0.999);
    assertEquals(0, actual);
  }
}