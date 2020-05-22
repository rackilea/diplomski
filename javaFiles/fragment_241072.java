public class RegexDemo {

    private static final Pattern PATTERN = Pattern.compile("(.+) (.+) \\[(.+)\\] - (.+)");

    public static void main(String[] args) {
        String[] matchStrings = {
                "(15-03-2017 11:12:47) nielsje41 [Niels] - this is a message",
                "(15-03-2017 11:12:47) nielsje41 [Niels] - this is another message",
                "(15-03-2017 11:12:47) nielsje41 [Niels] - testing (messages in parenthesis)"
        };
        for (String str : matchStrings) {
            Matcher matcher = PATTERN.matcher(str);
            if (matcher.matches()) {
                String dt = matcher.group(0);
                String user = matcher.group(1);
                String display = matcher.group(2);
                String message = matcher.group(3);

                System.out.println(dt);
                System.out.println(user);
                System.out.println(display);
                System.out.println(message);
            }
        }
    }
}