private static final Pattern REGEX_PATTERN = 
        Pattern.compile("(?<=\")[^\"]*(?=\"\\s|\"$)|[^\\s\"]+");

public static void main(String[] args) {
    String input = "test1 test2 \"test 3\" test4 \"test 5\"";

    Matcher matcher = REGEX_PATTERN.matcher(input);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }
}