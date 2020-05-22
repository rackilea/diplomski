import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class A {
  public static void main( String args[] ) {
    String p = "<=+|<-+|=+>|-+>|<|>";
    Matcher m = Pattern.compile(p).matcher(args[0]);
    while (m.find()) {
      System.out.println(m.group());
    }
  }
}