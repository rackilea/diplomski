public static boolean madeOutOfSameLetters(String a, String b) {
    if (a == null) {
        return b == null;
    } else if (b == null) {
        return false;
    }
    char[] left = a.toCharArray();
    char[] right = b.toCharArray();
    Arrays.sort(left);
    Arrays.sort(right);
    return Arrays.equals(left, right);
}

public static void main(String[] args) throws Exception {
    System.out.println(madeOutOfSameLetters("aaasdf", "xyz")); // false
    System.out.println(madeOutOfSameLetters("aaasdf", "asdf")); // false
    System.out.println(madeOutOfSameLetters("aaasdf", "aaasdd")); // false
    System.out.println(madeOutOfSameLetters("aaasdf", "fdsaaa"));// true
}