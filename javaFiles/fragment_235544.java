public static void main(String[] args) {
    printForPattern("x1x", System.out::println);
}

private static void printForPattern(String pattern, Consumer<CharSequence> consumer) {
    printForPattern(pattern, new StringBuilder(), consumer);
}

private static void printForPattern(String pattern, StringBuilder sb, Consumer<CharSequence> consumer) {
    int length = sb.length();
    if (pattern.length() == length) {
        consumer.accept(sb);
        return;
    }
    char ch = pattern.charAt(length);
    if (ch == 'x' || ch == '0') {
        sb.append('0');
        printForPattern(pattern, sb, consumer);
        sb.setLength(length);
    }
    if (ch == 'x' || ch == '1') {
        sb.append('1');
        printForPattern(pattern, sb, consumer);
        sb.setLength(length);
    }
}