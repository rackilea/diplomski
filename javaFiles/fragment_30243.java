public class IntIntArray {
  private int[][] values;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntIntArray that = (IntIntArray) o;
    return Arrays.deepEquals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(value);
  }
}