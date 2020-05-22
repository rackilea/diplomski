public class ResourceB {
  ResourceC c;

  public ResourceB() { c = new resourceC(); } // normal behavior

  @VisibleForTesting // guava annotation (in, order to expalain why there is this constructor)
  ResourceB(ResourceC c_override) { c = c_override; } // constructor for the test, note the package visibility

  // ...
}