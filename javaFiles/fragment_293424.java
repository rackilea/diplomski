public abstract class SuperState {
  public final long mValue;
  private SuperState(long value) { mValue = value; }
  protected SuperState(SuperState last) { mValue = last.mValue + 1; } 
  ...
  private static class FirstState extends SuperState {
    private FirstState() { super(0); }
  }
  public static SuperState getFirstState() { return new FirstState(); }
}