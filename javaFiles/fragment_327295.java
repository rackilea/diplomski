import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Ideone {
 public static void main(String[] args) throws java.lang.Exception {
  String regex = "(?:xxxxxxx)V[0-9]+_[0-9]+_[0-9]+(?:\\.[a-z]+)?";
  String string = "public void doSomething() {\n" 
                + "    return \"xxxxxxxV1_0_0.yyyyyyyy\";\n" 
                + "}";
  String subst = "xxxxxxxV2_0_0";

  Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
  Matcher matcher = pattern.matcher(string);

  String result = matcher.replaceAll(subst);
  System.out.println("Substitution result: " + result);
 }
}