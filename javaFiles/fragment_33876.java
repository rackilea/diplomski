import java.lang.Math;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;


public class HelloWorld
{
  public static void main(String[] args)
  {
    Integer counter = new Integer(0);
    String subjectString = "The quick brown fox jumps over the laziest dog in the world";
    String testWordString = "brown";
    try {
      Pattern regex = Pattern.compile("\\b(?:(brown)|(\\S+))\\b");
      Matcher regexMatcher = regex.matcher(subjectString);
      while (regexMatcher.find()) {
        // here increment a count for each word we pass.
        counter++;

        // matched text: regexMatcher.group()
        // match start: regexMatcher.start()
        // match end: regexMatcher.end()

        System.out.println(regexMatcher.group());

        // if the word text `regexMatcher.group()` matches our subject word `brown` exit the loop.
        if (testWordString.equals(regexMatcher.group())) {
          System.out.println("found the word: " + counter);
          break;
        }

      } 
    } catch (PatternSyntaxException ex) {
      // Syntax error in the regular expression
    }
  }
}