import java.util.EnumSet;


public class EnumSetExample
{
  enum Level { NONE, DEBUG, INFO, ERROR };

  public static void main(String[] args)
  {
    EnumSet<Level> subset = EnumSet.of(Level.DEBUG, Level.INFO);

    for(Level currentLevel : EnumSet.allOf(Level.class))
    {
      if (subset.contains(currentLevel))
      {
        System.out.println("we have " + currentLevel.toString());
      }
      else
      {
        System.out.println("we don't have " + currentLevel.toString());
      }
    }
  }

}