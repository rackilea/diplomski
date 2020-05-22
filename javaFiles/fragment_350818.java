public static boolean sameCharacters(String left, String right) {
    return sortCharacters(left).equals(sortCharacters(right));
}

private static String sortCharacters(String s) {
    final char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
}