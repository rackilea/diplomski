@RunWith(JUnit4.class) // JUnit4.class is a "runner".
public class BinarySearchTest {
  // By convention, the test for class Foo is named FooTest. You can name the
  // test anything you'd like, though, especially if you split your test for
  // Foo into more than one file.

  @Test public void isSortedShouldReturnTrueWhenSorted() { // Same with methods.
    assertTrue(BinarySearch.isSorted(new int[] { 2, 4, 6 }));
  }

  @Test public void isSortedShouldReturnFalseWhenUnsorted() {
    assertFalse(BinarySearch.isSorted(new int[] { 4, 2, 6 }));
  }

  @Test public void isSortedShouldReturnTrueWhenEmpty() {
    assertTrue(BinarySearch.isSorted(new int[] {}));
  }

  // Write more tests here!
}