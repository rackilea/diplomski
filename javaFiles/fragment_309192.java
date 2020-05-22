public static int[] parseBinaryToIntArray(String input) {
    // TODO: Validation
    int[] output = new int[input.length() / 32];
    for (int i = 0; i < output.length; i++) {
    String section = input.substring(i * 32, (i + 1) * 32);
        output[i] = (int) Long.parseLong(section, 2);
    }
    return output;
}