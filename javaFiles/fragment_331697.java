import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MainTest
{
  private static String key1;
  private static String key2;
  private static String key3;

  public static void main(String... pArgs)
  {
    try
    {
      Map<String, String> argMap = parseArgs(pArgs);
      mapStaticFields(argMap, MainTest.class);

      System.out.println(key1);
      System.out.println(key2);
      System.out.println(key3);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}