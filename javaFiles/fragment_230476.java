public class NestedParser {

    private final char opening;
    private final char closing;
    private String str;
    private List<String> matches;

    private int matchFrom(int beginIndex, boolean matchClosing) {
        int i = beginIndex;
        while (i < str.length()) {
            if (str.charAt(i) == opening) {
                i = matchFrom(i + 1, true);
                if (i < 0) {
                    return i;
                }
            } else if (matchClosing && str.charAt(i) == closing) {
                matches.add(str.substring(beginIndex, i));
                return i + 1;
            } else {
                i++;
            }
        }
        return -1;
    }

    public NestedParser(char opening, char closing) {
        this.opening = opening;
        this.closing = closing;
    }

    public List<String> match(String str) {
        matches = new ArrayList<>();
        if (str != null) {
            this.str = str;
            matchFrom(0, false);
        }
        return matches;
    }

    public static void main(String[] args) {
        NestedParser parser = new NestedParser('(', ')');
        System.out.println(parser.match(
                "((a=2 and age IN (15,18,56)) and (b=3 and c=4))"));
    }
}