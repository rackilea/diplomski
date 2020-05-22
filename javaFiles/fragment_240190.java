import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

   public static void main(String[] args)
   {
      final String regex = "src=(['\"])" // the ' or the " is in group 1
              + "(.*?)" // match any character in a non-greedy fashion
              + "\\1"; // closes with the quote that is in group 1
      Pattern p = Pattern.compile(regex);

      Matcher m = p.matcher("src=\"hello/\"  ...   src='goodbye/'  ... "
              + "src='this has a \" in it'");

      while (m.find())
      {
         System.out.println("\nfound!");
         System.out.println("The quote was a " + m.group(1));
         System.out.println("the text was = " + m.group(2));
      }
   }
}