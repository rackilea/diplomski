public class GlobMatcher {
    public static boolean match(String pattern, String text) {
        String rest = null;
        int pos = pattern.indexOf('*');
        if (pos != -1) {
            rest = pattern.substring(pos + 1);
            pattern = pattern.substring(0, pos);
        }

        if (pattern.length() > text.length())
            return false;

        for (int i = 0; i < pattern.length(); i++)
            if (pattern.charAt(i) != '?' 
                    && !pattern.substring(i, i + 1).equalsIgnoreCase(text.substring(i, i + 1)))
                return false;

        if (rest == null) {
            return pattern.length() == text.length();
        } else {
            for (int i = pattern.length(); i <= text.length(); i++) {
                if (match(rest, text.substring(i)))
                    return true;
            }
            return false;
        }
    }
}