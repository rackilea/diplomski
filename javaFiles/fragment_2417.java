import java.util.regex.*;
class Foo {
    private static final Pattern re
      = Pattern.compile("INSERT VALUES \\(.*?\\)|UPDATE SET .*;");
    static void find(String text) {
        Matcher m = re.matcher(text);
        while (m.find())
            System.out.println(m.group());
    }
}