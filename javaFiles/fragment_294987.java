@RunWith(Parameterized.class)
public class SorterTest {
  @Parameters
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][] {
      { new SelectionSort() },
      { new BubbleSort() }
    });
  }

  private final Sorter sorter

  public SorterTest(Sorter sorter) {
    this.sorter = sorter;
  }

  @Test
  public void arraySortedSingleElement(){
    String[] a = new String[]{"A"};
    Assert.assertTrue(sorter.isSorted(a));
  }

  @Test
  public void arraySortedDistinctElements(){
    String[] a = new String[]{"A","B","C","D"};
    Assert.assertTrue(sorter.isSorted(a));
  }

  @Test
  public void arrayNotSorted(){
    String[] a = new String[]{"A","B","C","B"};
    Assert.assertFalse(sorter.isSorted(a));
  }
}