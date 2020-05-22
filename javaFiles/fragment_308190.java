public class Main {
  public static void main(String[] main) {
    List<String> l = new LinkedList<String>();

    // Enter infinite loop which will add a String to
    // the list: l on each iteration.
    do {
      l.add(new String("Hello, World"));
    } while(true);
  }
}