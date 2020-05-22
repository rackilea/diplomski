import java.util.ArrayList;
import java.util.List;

public class Interleaver {

    /**
     * Returns a list containing all possible interleavings of two strings.
     * The order of the characters within the strings is preserved.
     */
    public static List<String> interleave(String s, String t) {
        List<String> result = new ArrayList<String>();
        if (t.isEmpty()) {
            result.add(s);
        } else if (s.isEmpty()) {
            result.add(t);
        } else {
            for (int i = 0; i <= s.length(); i++) {
                char c = t.charAt(0);
                String left = s.substring(0, i);
                String right = s.substring(i);
                for (String u : interleave(right, t.substring(1))) {
                    result.add(left + c + u);
                }
            }
        }
        return result;
    }

    /**
     * Prints some example interleavings to stdout.
     */
    public static void main(String[] args) {
        System.out.println(interleave("", ""));
        System.out.println(interleave("a", ""));
        System.out.println(interleave("", "1"));
        System.out.println(interleave("a", "1"));
        System.out.println(interleave("ab", "1"));
        System.out.println(interleave("ab", "12"));
        System.out.println(interleave("abc", "12"));
        System.out.println(interleave("ab", "1234"));
    }
}