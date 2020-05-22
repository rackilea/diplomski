import java.text.*;
import java.util.*;

public class Order {
  public static void main(String[] args) throws ParseException {
    List<String> list = Arrays.asList("a", "A", "\u00E6", "z", "Z", "1", "-");

    Collections.sort(list);
    print("Natural", list);

    Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
    print("Case insensitive", list);

    Collator norwegian = Collator.getInstance(new Locale("nb_NO"));
    norwegian.setStrength(Collator.PRIMARY);
    Collections.sort(list, norwegian);
    print("Localized natural language rules (Norwegian)", list);

    Collator custom = new RuleBasedCollator("< a< A< z< Z< '-'< 1");
    Collections.sort(list, custom);
    print("Custom", list);
  }

  private static void print(String what, Object value) {
    System.out.println(what);
    System.out.println(value);
  }
}