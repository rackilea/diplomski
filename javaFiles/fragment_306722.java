import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mkt {
  public static void main(String[] args) {
    Pattern p = Pattern.compile("([$\\d.,]+)|([\\w\\d!$]+)");
    String str = "--- FREE!! $50 192.168.1.1 $24,500";
    System.out.println("input: " + str);

    Matcher m = p.matcher(str);
    while(m.find()) {
      System.out.println("token: " + m.group());
    }
  }
}