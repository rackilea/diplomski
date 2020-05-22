byte[] a = new byte[8];
a[0] = (byte) 255;
a[1] = (byte) 253;
a[2] = (byte) 247;
a[3] = (byte) 191;
a[4] = (byte) 243;
a[5] = (byte) 191;
a[6] = (byte) 127;
a[7] = (byte)  63;

ByteBuffer buffer = ByteBuffer.wrap(a);
System.out.println(buffer.getLong());
// Result:
// 11111111 11111101 11110111 10111111 11110011 10111111 01111111 00111111