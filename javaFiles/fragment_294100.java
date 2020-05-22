public static boolean uniqueValues(char[] values) {
    boolean[] seen = new boolean[65536];
    for (char c : values) {
        int index = c;
        if (seen[index]) {
            return false;
        }
        seen[index] = true;
    }
    return true;
}