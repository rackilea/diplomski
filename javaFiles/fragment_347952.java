import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SO28290386 {
    public static void main(String[] args) {
        String WHITESPACE_RE = "[ ]"; // Modify this according to your grammar
        String PUNCTUATION_RE = "[.:,;?!_-]";
        String STRING_RE = "\"(?:[A-Za-z0-9" + WHITESPACE_RE + PUNCTUATION_RE + "\n])*\"";
        String VALUES_RE = STRING_RE + "(?:," + WHITESPACE_RE + STRING_RE + ")*";
        String PLAYERS_RE = "PLAYERS:" +  WHITESPACE_RE + "(" + VALUES_RE + ")(?=\r\n)";
        System.out.println(PLAYERS_RE);

        String input = "RESPONSE GAMEINFO OK\r\nNAME: \"gamelobby\"\r\nPLAYERS: \"alice\", \"bob\", \"hodor\", \"new\nline\"\r\nFLAGS: 1, 2, 3\r\n";
        System.out.println("INPUT");
        System.out.println(input);

        Pattern p = Pattern.compile(PLAYERS_RE);
        Matcher m = p.matcher(input);
        while (m.find()) {
            System.out.println(m.group(0));
            System.out.println(m.group(1));
        }
    }
}