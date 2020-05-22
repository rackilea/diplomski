public class abstract SuperClass {
  public abstract String myToString();

  public String toString() {
    return myToString();
  }
}