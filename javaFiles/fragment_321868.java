private static String repeat(char ch, int count) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
        sb.append(ch);
    }
    return sb.toString();
}