import java.util.regex.*;

public class RegexTest {

  public static void main(String args[]) {
    String s = "<a name=\"1.F\"></a>";
    Pattern p = Pattern.compile("<a name=\\\"(.*)\\\"");
    Matcher m = p.matcher(s);
    if (m.find()) {
      System.out.println(m.group(1));
    }
  }
}