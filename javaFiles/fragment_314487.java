public class Catalog {
private static int MAX_ITEMS = 10;

/**
 * List of Products objects.
 */
private Products[] list;
private int nextItem;

// your old code here

  // new code
  @Override
  public String toString() {
     return "this is a catalog";
  }        
}