final char[] key = {0x5f, 38, 3, 111, 110};

char[] decode(final char[] input) {
    final char[] output = new char[input.length];
    for (int i = 0; i < output.length; i++) {
        output[i] = (char)(input[i] ^ key[i % 5]);
    }
    return output;
}