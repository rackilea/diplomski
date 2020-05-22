import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        final String regex = "(?m)(?!.*\\bfailed)(?<=username\\s\\[)[^\\r\\n\\]]+";
        final String string = "    12:59:39.924 [ajp-nio-0.0.0.0-8009-exec-87] INFO  AuthenticationStrategy - Authentication for username [user1] & realm [SSORealm] successful.\n"
             + "    13:21:38.017 [ajp-nio-0.0.0.0-8009-exec-87] INFO  AuthenticationStrategy - Authentication for username [user2] & realm [Realm] successful.\n"
             + "    13:19:30.419 [ajp-nio-0.0.0.0-8009-exec-87] INFO  AuthenticationStrategy - Authentication for username [user1] & realm [LdapRealm] failed.\n"
             + "N";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
        }
    }
}