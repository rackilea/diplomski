import java.util.regex.*;
public class Test {
    public static void main(String...args) {
        String line = "\"hello world\" Alexandros Alex \"I Am\" Something";
        Pattern pattern = Pattern.compile("\\b(?:(?<=\")[^\"]*(?=\")|\\w+)\\b");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}