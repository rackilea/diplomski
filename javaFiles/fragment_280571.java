public static void printThatFollowPattern(String text, String pattern) {
    int i = 0;
    while (i < text.length()) {
        int indexOfNextPatternStart = text.indexOf(pattern, i);
        int indexOfCharAfterPattern = indexOfNextPatternStart + pattern.length();

        if (indexOfCharAfterPattern < text.length()) {
            char charAfterPattern = text.charAt(indexOfCharAfterPattern);
            System.out.println("charAfterPattern: " + charAfterPattern);
        } else {
            break;
        }

        i = indexOfCharAfterPattern + 1;
    }
}