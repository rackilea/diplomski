import java.util.regex.*;
public class Four {
    static String input = "A1 B1 P3 D1 D2 D3 D4 F3 F3 Z1 Z2 Z3 Z4 P2";
    static Pattern four = Pattern.compile("([A-Z])1 \\12 \\13 \\14");
    public static void main(String[] args) {
        Matcher m = four.matcher(input);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}