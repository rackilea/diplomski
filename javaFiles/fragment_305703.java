public class Main
{
  private static int integer = 15;

  public static int getInteger()
  {
    return integer;
  }
}

public class NeedInteger
{
  public NeedInteger()
  {
    int integer = Main.getInteger();
  }
}