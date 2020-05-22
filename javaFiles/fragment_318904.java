import java.util.*;
import static java.lang.Math.min;

public class T {
  public static void main( String args[] ) {
    List<String> items = Arrays.asList("1");
    List<String> subItems = items.subList(0, min(items.size(), 2));

    // Output: [1]
    System.out.println( subItems );

    items = Arrays.asList("1", "2", "3");
    subItems = items.subList(0, min(items.size(), 2));

    // Output: [1, 2]
    System.out.println( subItems );
  }
}