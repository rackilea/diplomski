byte[] bytes = new byte[] { 0x02, 0x05, 0x02, 0x5A };
DataInputStream pkt = new DataInputStream(new ByteArrayInputStream(bytes));
try {
    byte tab = pkt.readByte();
    byte color = pkt.readByte();
    short len = pkt.readShort();
    System.out.printf("tab=%d, color=%d, len=%d%n", tab, color, len);
} catch (IOException e) {
    e.printStackTrace();
}