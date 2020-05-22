import java.text.Collator;

/**
 * @author Kennedy
 */
public class SimpleTest
{

  public static void main(String[] args)
  {
    String a = "nocao";
    String b = "noção";

    final Collator instance = Collator.getInstance();

    // This strategy mean it'll ignore the accents
    instance.setStrength(Collator.NO_DECOMPOSITION);

    // Will print 0 because its EQUAL
    System.out.println(instance.compare(a, b));
  }
}