import java.util.regex.*;

class rTest {
  public static void main (String[] args) {
    String in = "#Login&oauth_token=theOAUTHtoken&oauth_verifier=12345";
    Pattern p = Pattern.compile("(?:&([^=]*)=([^&]*))");
    Matcher m = p.matcher(in);
    while (m.find()) {
      System.out.println(m.group(1) + ", " + m.group(2));
    }
  }
}