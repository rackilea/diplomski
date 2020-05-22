import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Main {
  public static void main(String[] args) {
  Pattern p = Pattern.compile("json\">(.*)</script>");
  String s = "<script type=\"application/ld+json\">{aa:11,bb:22,cc{dd:33,ee:55,ff:66}}</script>";
  Matcher m = p.matcher(s) ;  
  while (m.find()) {
        System.out.println("json string= " + m.group(1));
  }
 }
}