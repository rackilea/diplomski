public static String getGuidFromByteArray(byte[] bytes) {
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    long high = bb.getLong();
    long low = bb.getLong();
    UUID uuid = new UUID(high, low);
    return uuid.toString();
}