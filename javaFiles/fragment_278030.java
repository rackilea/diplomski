public class TheExample
{
  private static Scanner stdin;

  public static void main(String[] args)
  {
    stdin = new Scanner(System.in);       // assign the static field ...
    foo();                                // ... then just invoke foo without parameters
  }

  private static void foo()
  {
    String s = stdin.next();              // use the static field
  }
}