/**
 * 
 * HTML 4 Specification ID and NAME tokens must begin with a letter
 * ([A-Za-z]) and may be followed by any number of letters, digits ([0-9]),
 * hyphens ("-"), underscores ("_"), colons (":"), and periods (".").
 * 
 * @param s
 * @return
 */
public static String sanitizeHTMLIdAttribute(String s) {
    if (s == null) return null;
    StringBuilder sb = new StringBuilder();
    int firstLegal = 0;
    while (firstLegal < s.length() && !isAZ(s.charAt(firstLegal)))
        ++firstLegal;
    for (int i = firstLegal; i < s.length(); ++i){
        final char ch = s.charAt(i);
        if (isOkIdInnerChar(ch)) sb.append(ch);
    }
    return sb.length() == s.length()? s : sb.toString();
}

private static boolean isOkIdInnerChar(char ch) {
    return isAZ(ch) || isNum(ch) || isSpecial(ch);
}

private static boolean isSpecial(char ch) {
    switch (ch) {
    case '-': case '_':
    case ':': case '.':
        return true;
    default:
        return false;
    }
}

private static boolean isAZ(char ch) {
    return ('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z'); 
}

private static boolean isNum(char ch) {
    return '0' <= ch && ch <= '9';
}