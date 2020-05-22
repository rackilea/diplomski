public class SortMediator implements RowSorterListener {
  private final List<RowSorter> sorters;
  private boolean changing;

  public void addRowSorter(RowSorter sorter) {
    this.sorters.add(sorter);
  }

  public void sorterChanged(RowSorterEvent e) {
    ...
  }
}