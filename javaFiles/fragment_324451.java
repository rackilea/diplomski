public class CharBeforeAndAfterSubstring {
    public static String wordEnds(String str, String word) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(word);
        java.util.regex.Matcher m = p.matcher(str);
        StringBuilder beforeAfter = new StringBuilder();

        for (int startIndex = 0; m.find(startIndex); startIndex = m.start() + 1) {
            if (m.start() - 1 > -1)
                beforeAfter.append(Character.toChars(str.codePointAt(m.start() - 1)));
            if (m.end() < str.length())
                beforeAfter.append(Character.toChars(str.codePointAt(m.end())));
        }

        return beforeAfter.toString();
    } 
    public static void main(String[] args) {
        String x = "abcXY1XYijk";
        String y = "XY";
        System.out.println(wordEnds(x, y));

    }
}