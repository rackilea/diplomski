public class MyTable extends Table {
  private int[] widths;
  public MyTable(TableModel tm, int... widths) {
    super(tm, true);
    this.widths = widths;
  }