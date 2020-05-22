public static void printMatches(String text, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    // Check all occurrences
    while (matcher.find()) {
        System.out.print("Start index: " + matcher.start());
        System.out.print(" End index: " + matcher.end());
        System.out.println(" Found: " + matcher.group());
    }
}