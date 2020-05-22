import java.util.Random;
public class StaticRandom
{
  private static final boolean useRandomValues = true;
  private static final Random r = new Random();
  private static final int value1;
  private static final int value2;
  private static final int value3;
  static
  {
    if(useRandomValues)
    {
      value1 = r.nextInt();
      value2 = r.nextInt();
      value3 = r.nextInt();
    }
    else
    {
      value1 = 0;
      value2 = 0;
      value3 = 0;
    }
  }
}