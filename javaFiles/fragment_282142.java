class ColumnComparator<T extends Comparable<T>> implements Comparator<T[]> {
  private final int column;

  ColumnComparator(int column) { this.column = column; }

  @Override public int compare(T[] a, T[] b) {
    return a[column].compareTo(b[column]);
  }
}