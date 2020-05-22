public final class Parser {
    public static void main(final String[] args) {
        if (args.length < 1) {
            // Error, no input given
        }

        String input = args[0];

        Pattern pattern = Pattern.compile("YOUR REGEX HERE");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Input matches the Regex pattern
            // Access to capturing groups using matcher.group(int)
            // Example: System.out.println(matcher.group(1));
        }
    }
}