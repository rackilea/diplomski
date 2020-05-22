private static boolean isUnique(String inputString) {
    long[] used = new long[1024];
    for (char c : inputString.toCharArray()) {
        if ((used[c >>> 6] & (1 << c)) > 0) {
            return false;
        }
        used[c >>> 6] |= 1 << c;
    }
    return true;
}