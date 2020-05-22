public class HootUtility // Not a singleton because I am not a ______. (fill in the blank as you see fit)
{
  // You can limit instantiation but never prevent instantiation.
  // google "java reflection" for details.
  private HootUtility()
  {
    throw new UnsuppotedOperationException();
  }

  public static void blammy(...) { ... }
}

... somewhere in the code.

HootUtility.blammy(...);