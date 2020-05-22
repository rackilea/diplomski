A a = new A();
a.a = 3;
a.b = 0x02;
a.c = 15;

ByteBuffer bb = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
bb.putShort(a.a).put(a.b).putInt(a.c).flip();
byte[] buffer = bb.array();
for (byte b : buffer)
    System.out.printf("%02X ", b);