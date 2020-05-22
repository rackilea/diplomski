public static String count(String s, char a) {
    String result = "";
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == a) {
            result += (i+1) + ", ";
        }
    }
    return result.substring(0, result.length() - 2);
}