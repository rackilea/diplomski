import java.util.regex.*;

public class Test {

    public static String foo(String str) {
        return "<b>" + str + "</b>";
    }

    public static void main(String[] args) {
        String content = "Some Text";
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher m = pattern.matcher(content);

        StringBuffer sb = new StringBuffer();

        while (m.find())
            m.appendReplacement(sb, foo(m.group()));

        m.appendTail(sb);

        System.out.println(sb);
    }
}