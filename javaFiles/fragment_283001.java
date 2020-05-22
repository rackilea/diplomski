public class Test {
  @Rule
  public final TestRule doNotRunOnProd = new DoNotRunOnProd();

  ...
}