import java.util.*;
import java.util.regex.*;

public class Test
{
  public static void main(String[] args) throws Exception
  {
    String s = "Lorem ipsum {foo} impedit civibus ei pri, legimus\n" +
        "antiopam no {marco}, quo id everti forensibus maiestatis.";
    Map<String,Object> p = new HashMap<String,Object>()
    {{
      put("foo", "BAR");
      put("marco", "POLO!");
    }};
    System.out.printf("%s%n%n%s%n", s, supplant(s, p));
  }

  public static CharSequence supplant(CharSequence message, Map<String,Object> params)
  {
    Matcher m = Pattern.compile("\\{(\\w+)\\}").matcher(message);
    StringBuffer sb = new StringBuffer();
    while (m.find())
    {
      m.appendReplacement(sb, "");
      String key = m.group(1);
      sb.append(params.get(key).toString());
    }
    m.appendTail(sb);
    return sb.toString();
  }
}