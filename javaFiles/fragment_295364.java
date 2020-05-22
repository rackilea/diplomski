import java.net.URLEncoder;
import java.util.regex.Pattern;

public class Foobar {
  private static Pattern space = Pattern.compile("\\+");
  public static void main(String[] args) throws Exception {
    String first = URLEncoder.encode("Ä+ \r\n/", "UTF-8");
    String second = space.matcher(first).replaceAll("%20");
    System.out.println(second);
  }
}