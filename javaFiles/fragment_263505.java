public static String starOut(String s) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '*') continue;
        if (i > 0 && s.charAt(i - 1) == '*') continue;
        if (i < s.length() - 1 && s.charAt(i + 1) == '*') continue;

        sb.append(s.charAt(i));
    }

    return sb.toString();
}