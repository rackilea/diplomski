import java.util.*;
import java.util.regex.*;

class Test {
    public static void main(String[] args) {

        Map<String, String> variables = new HashMap<String, String>() {{
            put("myfile1", "/path/to/file1");
            put("myfile2", "/path/to/file2");
        }};

        String input = "cp $myfile1 $myfile2";

        // Create a matcher for pattern $\S+
        Matcher m = Pattern.compile("\\$(\\S+)").matcher(input);
        StringBuffer sb = new StringBuffer();

        while (m.find())
            m.appendReplacement(sb, variables.get(m.group(1)));
        m.appendTail(sb);

        System.out.println(sb.toString());
    }
}