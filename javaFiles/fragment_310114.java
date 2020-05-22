import java.util.*;
import java.util.regex.*;

public class RegexDemo {

  public static void main( String[] argv ) {
    String pat = "^([0-9.]*).*?\\[(\\d+\\/\\w+\\/\\d+):(\\d+:\\d+:\\d+).*?\\].*?(\\/[^ ]*).*$";
    Pattern p = Pattern.compile(pat);
    String target = "70.80.110.200 -  -  [12/Apr/2011:05:47:34 +0000] \"GET /notify/click?r=http://www.xxxxxx.com/hello_world&rt=1302587231462&iid=00000 HTTP/1.1\" 302 0 \"-\" \"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; FunWebProducts; HotbarSearchToolbar 1.1; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; AskTbFWV5/5.11.3.15590)\" 4 4";
    Matcher m = p.matcher(target);
    System.out.println("pattern: " + pat);
    System.out.println("target: " + target);

    if (m.matches()) {
      System.out.println("found");
      for (int i=0; i <= m.groupCount(); ++i) {
        System.out.println(m.group(i));
      }
    }
  }
}