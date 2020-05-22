public abstract class SuperState {
  public final long mValue;
  private SuperState(long value) { mValue = value; }
  protected SuperState(SuperState last) { mValue = last.mValue + 1; } 
  ...
  public static class FirstState {
    //Can call SuperState(long) from here
  }
}