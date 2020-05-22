public class ReversableArray {
  private boolean reverse = false;
  private final int[] array;
  public ReversableArray(int[] array) { this.array = array; }

  public int get(int index) {
    return reverse ? array[array.length - index - 1] : array[index];
  }
  public void reverse() { reverse = !reverse; }
}