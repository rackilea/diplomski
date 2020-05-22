private static final Pattern REGEX_PATTERN = 
        Pattern.compile("(?i)\\bvirtue('?s)?\\b");

public static void main(String[] args) {
    String input = "virtue\nvirtues\nVIRTUE\nVIRTUES\nvirtue's or VIRTUE'S";
    Matcher matcher = REGEX_PATTERN.matcher(input);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }

}