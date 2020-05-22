public static int HEADER_SIZE = 2 + 8 + 4;

public static byte[] extractAvroBytes(byte[] bytesToStore) throws IOException {
    byte[] bytes = Arrays.copyOfRange(bytesToStore, HEADER_SIZE, bytesToStore.length);
    return Snappy.uncompress(bytes);
}