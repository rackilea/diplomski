public class Data implements Comparable<Data> {
  private final int prefix;
  private final int suffix;

  public Data(String str) {
    String[] arr = str.split(":");

    if (arr.length != 2) {
      throw new IllegalArgumentException();
    }

    this.prefix = Integer.parseInt(arr[0]);
    this.suffix = Integer.parseInt(arr[1]);
  }

  public int compareTo(Data data) {
    // Should really avoid subtraction in case of overflow but done to keep code brief.
    int ret = this.prefix - data.prefix;

    if (ret == 0) {
      ret = this.suffix - data.suffix;
    }

    return ret;
  }

  // TODO: Implement equals and hashCode (equals to be consistent with compareTo).

  public String toString() { return String.format("%d:%d", prefix, suffix); }
}