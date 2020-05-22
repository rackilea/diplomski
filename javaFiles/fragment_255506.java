public static final String nextIpAddress(final String input) {
    final String[] tokens = input.split("\\.");
    if (tokens.length != 4)
        throw new IllegalArgumentException();
    for (int i = tokens.length - 1; i >= 0; i--) {
        final int item = Integer.parseInt(tokens[i]);
        if (item < 255) {
            tokens[i] = String.valueOf(item + 1);
            for (int j = i + 1; j < 4; j++) {
                tokens[j] = "0";
            }
            break;
        }
    }
    return new StringBuilder()
    .append(tokens[0]).append('.')
    .append(tokens[1]).append('.')
    .append(tokens[2]).append('.')
    .append(tokens[3])
    .toString();
}