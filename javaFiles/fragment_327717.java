public static void main(String[] args) {
    byte[] bytes = {1, 2, 3, 4, 5, 6, 7, 8};
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    print(bb.order(ByteOrder.BIG_ENDIAN));
    print(bb.order(ByteOrder.LITTLE_ENDIAN));
}

private static void print(ByteBuffer bb) {
    System.out.println("With " + bb.order() + " byte order");
    for (int i = 0; i < bb.capacity(); i++)
        System.out.println("byte " + i + ": " + bb.get(i));
    for (int i = 0; i < bb.capacity() - 2; i++)
        System.out.println("short " + i + ": " + Integer.toHexString(bb.getShort(i)));
    for (int i = 0; i < bb.capacity() - 3; i++)
        System.out.println("int " + i + ": " + Integer.toHexString(bb.getInt(i)));
}