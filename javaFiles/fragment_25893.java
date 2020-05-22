import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Foo {
    public static void main(String[] args) {
        String[] examples = {
                "David Warner lbw b. Hassan 19 16 4 0 118.8%",
                "Joe Burns b. Morkel 73 149 16 0 49.0%",
                "Asad Shafiq c. Rahane b. Morkel 22 38 5 0 57.9%",
                "Yasir Shah not out 1 12 0 0 8.3%",
                "Yasir Shah st Rahane 1 12 0 0 8.3%",
                "Morne Morkel run out (Shah) 11 17 1 1 64.7%"
        };

        Pattern pattern = Pattern.compile("(\\/?[A-Z][a-z]+(?:\\s(?:[A-Z]['a-z]+)+))(?:\\s+(lbw|not\\sout|(c\\.|st|run\\sout)\\s\\(?(\\w+)\\)?))?(?:\\s+((?:b\\.\\s)(\\w+)))?\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+\\.\\d%)");
        for (String text : examples) {
            System.out.println("TEXT: " + text);
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches()) {
                System.out.println("batsman: " + matcher.group(1));
                if (matcher.group(2) != null) System.out.println(matcher.group(2));
                if (matcher.group(5) != null && matcher.group(5).matches("^b.*"))
                    System.out.println("bowler: " + matcher.group(6));
                StringBuilder sb = new StringBuilder("numbers are: ");
                int[] groups = {7, 8, 9, 10, 11};
                for (int i : groups) {
                    sb.append(" " + matcher.group(i));
                }
                System.out.println(sb.toString());
                System.out.println();
            }
        }
    }
}