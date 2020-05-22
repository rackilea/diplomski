class MyDataGroupComparator implements Comparator<MyData> {
  private final int column;
  protected MyDataGroupComparator(int column) {
    this.column = column;
  }
  @Override public int compare(MyData a, MyData b) {
    if (a == null && b == null) {
      return 0;
    } else if (a != null && b == null) {
      return -1;
    } else if (a == null && b != null) {
      return 1;
    } else {
      int v = a.getName().compareTo(b.getName());
      if (v == 0) {
        switch (column) {
        case 2:
          return a.getBook().compareTo(b.getBook());
        case 1:
          return a.getDuration() - b.getDuration();
        case 0:
        default:
          return v;
        }
      }
      return v;
    }
  }
}