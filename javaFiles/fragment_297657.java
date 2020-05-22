public static void main(String[] args) throws Exception {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byteArrayOutputStream.write(new byte[] { 0, 3,
            4, 5, (byte)128, 0, 0, 3, 0, 0, 3, 5, 0XC, 7, 0, (byte)8, 0, 0, 0, 0, 0, 0,
            0, 3, 0, 0, 3, 5, 0XC, 7, 0, 8, 0, 1, 0, 0, 0, 0, 0, 0, 4 });
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
            byteArrayOutputStream.toByteArray());
    PacketInputStream is = new PacketInputStream(byteArrayInputStream);
    System.out
            .println("Logic data version (always 0) : " + is.readVarInt());
    System.out.println("User ID: " + is.readVarLong());
    System.out.println("Home ID: " + is.readVarLong());
}