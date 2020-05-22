public class StringUtility {
    public static boolean endsWith(String str, String[] delimiters) {
        for (String delimiter : delimiters) {
            if (str.endsWith(delimiter)) {
                return true;
            }
        }
        return false;
    }
}