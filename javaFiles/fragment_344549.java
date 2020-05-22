import java.util.*;
import java.lang.*;
import java.util.regex.*;

class Main {

        static final String[] testcases = new String[] {
            "'Tumblr' is an amazing app",
        "Tumblr is an amazing 'app'",
        "Tumblr is an 'amazing' app",
        "Tumblr is 'awesome' and 'amazing' ",
        "Tumblr's users' are disappointed ",
        "Tumblr's 'acquisition' complete but users' loyalty doubtful"
        };

    public static void main (String[] args) throws java.lang.Exception {
        Pattern p = Pattern.compile("(?:^|\\s)'([^']*?)'(?:$|\\s)", Pattern.MULTILINE);
        for (String arg : testcases) {
            System.out.print("Input: "+arg+" -> Matches: ");
            Matcher m = p.matcher(arg);
            if (m.find()) {
                System.out.print(m.group());
                while (m.find()) System.out.print(", "+m.group());
                System.out.println();
            } else {
                System.out.println("NONE");
            }
        } 
    }
}