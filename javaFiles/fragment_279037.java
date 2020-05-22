public static String randomString(int size) {
    if (size <= 0)
        throw new RuntimeException("Zero-length randomString is useless.");

    final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    StringBuilder objectId = new StringBuilder();
    Random random = new Random();

    for (int i = 0; i < size; ++i)
        objectId.append(chars[random.nextInt(Integer.MAX_VALUE) % chars.length]);

    return objectId.toString();
}