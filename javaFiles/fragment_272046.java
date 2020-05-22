import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SplitDemo2 {

    private static final String REGEX = "/\\r\\n(.*?)\\$/";
    private static final String INPUT = "/GET (.*) HTTP/";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // get a matcher object
        int count = 0;

        while(m.find()) {
          count++;
          System.out.println("Match number "+count);
          System.out.println("start(): "+m.start());
          System.out.println("end(): "+m.end());
   }
}