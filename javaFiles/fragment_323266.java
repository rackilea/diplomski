import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPatternMatch {
    public static void main(String[] args) {
        List<User> result = new ArrayList<>();
        String input =
                "Wilson#$20#$Male=@=Raymond#$25#$Male=@=Sophie#$30#$Female";
        Pattern recPatt =
                Pattern.compile("^(=@=|.{0})(.+?)#\\$(\\d+)#\\$(.+?)(?==@=)(.*$)");
        //                       ^match start of line
        //                        ^match record delimiter or nothing
        //                                  ^match name field (reluctant)
        //                                       ^match field delim
        //                                           ^match age field
        //                                                 ^match field delim
        //                                   match gender field^
        // zero-width (non recording) lookahead for record delimiter^
        //                                     match rest of line until end^

        Matcher recMatcher;
        String workStr = input; // start with whole input
        while (workStr != null && workStr.length() > 0) {
            recMatcher = recPatt.matcher(workStr);
            if (recMatcher.matches() && recMatcher.groupCount() >= 5) {
                result.add(
                        new User(
                                recMatcher.group(2), //name
                                Integer.parseInt(recMatcher.group(3)), //age
                                recMatcher.group(4) //gender
                        )
                );
                workStr = recMatcher.group(5); // use tail for next iteration
            } else {
                workStr = null;
            }
        }
        System.out.println(result); //show result list contents
    }
}

class User {
    String  name;
    int     age;
    String  gender;
    /** All argument constructor */
    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    /** Show contents of object fields */
    public String toString() {
        return "User ["+ name + ", " + age + ", " + gender + "]";
    }
}