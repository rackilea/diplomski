import java.util.regex.Matcher;
import java.util.regex.Pattern;

      public class Test {
            public static void main(String[] args) {
                String input = "{\"string name\"=hi;\"id\"=44401234;\"string name\"=hey;\"id\"=87695432.....}";
                Pattern pattern = Pattern.compile("\"id\"=[0-9]{8}");
                Matcher m = pattern.matcher(input);
                while (m.find()) {
                    String str = m.group();
                    str = str.replace("\"id\"=", "");
                    System.out.println(str);
                }
            }

        }