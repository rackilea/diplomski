import java.util.regex.Pattern;
import java.util.regex.Matcher;

class RegExTest
{
  public static void main(String[] args){
    String sourcestring = "ON cONfirmation, put * your hat";
    sourcestring = sourcestring.replaceAll("(?<=\\s|^)(ON|\\*N|O\\*|\\*)(?=\\s|$)","").replaceAll("  "," ").trim();
    System.out.println("sourcestring=["+sourcestring+"]");
  }
}