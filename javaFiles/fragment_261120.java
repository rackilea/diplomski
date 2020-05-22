private static final Pattern pattern = Pattern.compile("(?<=\\w)(\\s+)");

public static void main(String[] args) {

  String text = "Here    is a test";

  System.out.println("countWhitespaces(text) = " + countWhitespaces(text));
}

private static int countWhitespaces(String text) {
    Matcher matcher = pattern.matcher(text);
    if (matcher.find()) {
        return matcher.group().length();
    }
    return 0;
}