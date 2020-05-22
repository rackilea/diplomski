private static String toBinaryString(int i) {
    StringBuilder binary = new StringBuilder();
    for (int t = i; t != 0; t >>= 1) {
        binary.append((i & t) != 0 ? 1 : 0);
    }
    return binary.toString();
}