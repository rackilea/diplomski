import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

   public static void main( String args[] ) {
      // String to be scanned to find the pattern.
      String input = "<li> text </li> <li> text </li> <p>  text </p> <p>  text </p><li> text<span>more test</span> </li><li> text </li>";
      String pattern1 = "(?<!</li>\\s{0,100})(<li>)";
      String replace1 = "<ul><li>";

      String pattern2 = "</li>(?!\\s{0,100}<li>)";
      String replace2 = "</li></ul>";

      // Create a Pattern object
      Pattern r1 = Pattern.compile(pattern1);
      Pattern r2 = Pattern.compile(pattern2);
      // Now create matcher object.
      Matcher m1 = r1.matcher(input);

      input = m1.replaceAll(replace1);

      Matcher m2 = r2.matcher(input);
      input = m2.replaceAll(replace2);
      System.out.println(input);

   }
}