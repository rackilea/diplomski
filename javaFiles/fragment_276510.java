public class SomethingImpl implements Something {
  private final String data;

  public SomethingImpl(String data) {
    this.data = data;
  }

  public SomethingImpl(Integer data) {
    this.data = data.toString();
  }
}