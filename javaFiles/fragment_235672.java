private static void test(String input) {
    String regex = "<\\s*script\\s*>|alert\\s*\\(\\s*\\)";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(input);
    if (m.find()) {
        System.out.println("#1  " + input);
    } else {
        System.out.println("#2  " + input);
    }
}