package reversestring;

// import java.io.* is not needed here. 
// And if you want to import anything,
// prefer specific imports instead and not entire package.

// java.lang.* is auto-imported. You needn't import it explicitly.      

public class Propogate {
  // There's no reason this method should be an object method. Make it static.
  public static String reverse(String name) {
    if (name == null || name.length() == 0) {
      // RuntimeExceptions are preferred for this kind of situations.
      // Checked exception would be inappropriate here.
      // Also, the error message should describe the kind of exception
      // occured.
      throw new RuntimeException("Empty name!");
    }
    // Idiomatic method of string reversal:
    return new StringBuilder(name).reverse().toString();
  }

  public static void main(String[] args) {
    String name;
    try {
      name = Propogate.reverse("java");
      System.out.println("Reversed string: " + name);
    } catch (RuntimeException rx) {
      System.err.println(rx.getMessage());
    } finally {
      // I don't get the point of `finally` here. Control will reach this
      // point irrespective of whether string reversal succeeded or failed.
      // Can you explain what do you mean by "done" below?
      System.out.println("done");
    }
  }
}