try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
    dis.skip(bytesToSkip);
    int length = Integer.reverseBytes(dis.readInt());
    byte[] bytes = new bytes[length];
    dis.readFully(bytes);
    return new String(bytes, "UTF-8");
}