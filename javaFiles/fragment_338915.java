public static String chopPrefix(String s, String prefix) {
    if (s.startsWith(prefix)) {
        return s.substring(prefix.length());
    } else {
        return s;
    }
}
public static String chopSuffix(String s, String suffix) {
    if (s.endsWith(suffix)) {
        return s.substring(0, s.length() - suffix.length());
    } else {
        return s;
    }
}
public static String chopPresuffix(String s, String presuffix) {
    return chopSuffix(chopPrefix(s, presuffix), presuffix);
}