public static boolean sameCharacters(String left, String right) {
    return Arrays.equals(sortCharacters(left), sortCharacters(right));
}

private static char[] sortCharacters(String s) {
    final char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return chars;
}