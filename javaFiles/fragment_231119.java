public class TabToSpaces
{
    public static void main(String[] args) {
        System.out.println(replaceTab("\tb", 8, "."));
        System.out.println(replaceTab("a\tb", 8, "."));
        System.out.println(replaceTab("abcdefg\th", 8, "."));
        System.out.println(replaceTab("abcdefgh\ti", 8, "."));
        System.out.println(replaceTab("a\tb\tc\td\te", 8, "."));
        System.out.println(replaceTab("ab\tb\tc\td\te", 8, "."));
    }

    private static String replaceTab(String string, int tabSize, String space) {
        Pattern pattern = Pattern.compile("\t");
        Matcher matcher = pattern.matcher(string);
        StringBuffer sb = new StringBuffer();
        int offset = 0;
        while (matcher.find()) {
            int beforeLength = matcher.start() + offset;
            int spacesNeeded = (int) (Math.ceil((beforeLength + 1.0) / tabSize) * tabSize) - beforeLength;
            offset += spacesNeeded - 1;
            String spaces = new String(new char[spacesNeeded]).replace("\0", space);
            matcher.appendReplacement(sb, spaces);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}