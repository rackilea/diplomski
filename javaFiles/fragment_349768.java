import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Test {

        public static void main (String[] args) {

            String s = "%s my string with %s";

            int i = 0;
            Pattern p = Pattern.compile("%s");
            Matcher m = p.matcher(s);
            while (m.find()) {
                i++;
            }
            System.out.println(i);
        }
    }