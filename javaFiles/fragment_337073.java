static String replace2(String s, String target, String replacement) {
    StringBuilder sb = null;
    int start = 0;
    for (int i; (i = s.indexOf(target, start)) != -1; ) {
        if (sb == null) sb = new StringBuilder();
        sb.append(s, start, i);
        sb.append(replacement);
        start = i + target.length();
    }
    if (sb == null) return s;
    sb.append(s, start, s.length());
    return sb.toString();
}

public static void main(String... ignored) {
    String s1 = "11112233211";
    for (; ; ) {
        timeReplace(s1);
        timeReplace2(s1);
        timeStringReplaceRefactored(s1);
        timeStringReplace(s1);
    }
}

private static void timeStringReplace(String s1) {
    long start0 = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
        String s2 = s1.replace("11", "xxx");
        if (s2.length() <= s1.length()) throw new AssertionError();
    }
    System.out.printf("String.replace %,d ns avg%n", System.currentTimeMillis() - start0);
}

private static void timeStringReplaceRefactored(String s1) {
    long start0 = System.currentTimeMillis();
    Pattern compile = Pattern.compile("11", Pattern.LITERAL);
    String xxx = Matcher.quoteReplacement("xxx");
    for (int i = 0; i < 1000000; i++) {
        String s2 = compile.matcher(s1).replaceAll(xxx);
        if (s2.length() <= s1.length()) throw new AssertionError();
    }
    System.out.printf("String.replace %,d ns avg (Refactored)%n", System.currentTimeMillis() - start0);
}
private static void timeReplace(String s1) {
    long start0 = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
        String s2 = replace(s1, "11", "xxx");
        if (s2.length() <= s1.length()) throw new AssertionError();
    }
    System.out.printf("Replace %,d ns avg%n", System.currentTimeMillis() - start0);
}

private static void timeReplace2(String s1) {
    long start0 = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
        String s2 = replace2(s1, "11", "xxx");
        if (s2.length() <= s1.length()) throw new AssertionError();
    }
    System.out.printf("My replace %,d ns avg%n", System.currentTimeMillis() - start0);
}

static String replace(String s, String target, String replacement) {
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; (i = sb.indexOf(target, i)) != -1; i += replacement.length()) {
        sb.replace(i, i + target.length(), replacement);
    }
    return sb.toString();
}