public static boolean uniqueValues(char[] values) {
    Set<Character> set = new HashSet<Character>();
    for (char c : values) {
        if (!set.add(c)) {
            return false;
        }
    }
    return true;
}