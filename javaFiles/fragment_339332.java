public static void main(String[] args) {
    String a = "Hello World!";
    CRC32 crc = new CRC32();
    crc.update(a.getBytes());
    System.out.println(Long.toHexString(crc.getValue()));
}