private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

public String generateString(int length) {
    Random random = new Random();
    StringBuilder builder = new StringBuilder(length);

    for (int i = 0; i < length; i++) {
        builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
    }

    return builder.toString();
}