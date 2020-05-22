public static void writeLong(String filename, long number) throws IOException {
    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
        dos.writeLong(number);
    }
}

public static long readLong(String filename, long valueIfNotFound) {
    if (!new File(filename).canRead()) return valueIfNotFound;
    try (DataInputStream dis = new DataInputStream(new FieInputStream(filename))) {
        return dis.readLong();
    } catch (IOException ignored) {
        return valueIfNotFound;
    }
}