private static long toLong(String hex) {
    hex = hex.replace(" ", "") + "00000000";
    byte[] data = DatatypeConverter.parseHexBinary(hex);
    return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getLong();
}

public static void main(String[] args) throws Exception {
    System.out.println(toLong("54 00 00 00"));
    System.out.println(toLong("55 F1 2E 04"));
    System.out.println(toLong("A2 3F 32 01"));        
    System.out.println(toLong("FF FF FF FF"));
}