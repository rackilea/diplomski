private static boolean isUnique2(String inputString) {
    boolean[] used = new boolean[65536];
    for (char c : inputString.toCharArray()) {
        if (used[c]) {
            return false;
        }
        used[c] = true;
    }
    return true;
}