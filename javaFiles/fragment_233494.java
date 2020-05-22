public static boolean hasDuplicateChars(String string) {
    Set<Character> chars = new HashSet<Character>();
    for (char c : string.toCharArray()) {
        if (!chars.add(c)) return false;
    }
    return true;
}