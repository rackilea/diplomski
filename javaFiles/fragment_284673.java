private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
public static void binary(int n, String str, int i) {
    if (i == ALPHABET.length())
        return;
    if (n == 0) {
        System.out.println(str);
        return;
    }
    binary(n - 1, str + ALPHABET.charAt(i), 0); // next letter starts at beginning of alphabet
    binary(n, str, i + 1); // do it again using next letter of alphabet
}