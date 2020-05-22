public class ArithmeticSeries extends AbstractList<Integer> {
  private final int start;
  private final int step;
  private final int size;

  public ArithmeticSeries(int start, int end, int step) {
    this.start = start;
    this.step = (start < end) ? step : -step;
    this.size = (end - start) / this.step + 1;
  }

  @Override public Integer get(int index) {
    return start + step * index;
  }

  @Override public int size() {
    return size;
  }
}