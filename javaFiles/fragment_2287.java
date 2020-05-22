import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class TestQuicksort {
  @Test
  public void emptyArray() {
    QuickSort q = new QuickSort();
    int[] a = {};
    q.sort(a);
    assertEquals(0, a.length);
  }

  @Test
  public void oneElement() {
    QuickSort q = new QuickSort();
    int[] a = {0};
    q.sort(a);
    assertEquals(1, a.length);
    assertEquals(0, a[0]);
  }

  @Test
  public void oneTwo() {
    QuickSort q = new QuickSort();
    int[] a = {1, 2};
    q.sort(a);
    assertEquals(2, a.length);
    assertEquals(1, a[0]);
    assertEquals(2, a[1]);
  }

  @Test
  public void twoOne() {
    QuickSort q = new QuickSort();
    int[] a = {2, 1};
    q.sort(a);
    assertEquals("Array is " + Arrays.toString(a), 1, a[0]);
    assertEquals(2, a[1]);
  }
}