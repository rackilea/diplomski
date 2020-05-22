final Charset charset = Charset.forName(charsetName);
for (int i = 0; i < 255; i++) {
    ByteBuffer bb = ByteBuffer.allocate(4);
    bb.putInt(i);
    System.out.println(new String(bb.array(), charset).trim());
}