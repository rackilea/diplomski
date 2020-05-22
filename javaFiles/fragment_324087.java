public final class AlphabetEncoder
{
    private static final char[] ALPHABET = { '0', '1', '2', ...., 'z' };
    private static final int ENCODE_LENGTH = ALPHABET.length;

    public static String encode(int victim)
    {
        final List<Character> list = new ArrayList<>();

        do {
            list.add(ALPHABET[victim % ENCODE_LENGTH]);
            victim /= ENCODE_LENGTH;
        } while (victim > 0);

        Collections.reverse(list);
        return new String(list.toArray(new char[list.size()],
            StandardCharsets.UTF_8);
    }

    public int decode(final String encoded)
    {
        int ret = 0;
        char c;
        for (int index = 0; index < encoded.length(); index++) {
            c = encoded.charAt(index);
            ret *= ENCODE_LENGTH;
            ret += Arrays.binarySearch(ALPHABET, c);
       }
       return ret;
    }
}