byte[] bytes = Base64.getDecoder().decode("8AG...");
ShortBuffer buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
int npoints = bytes.length / 4;
for (int i = 0; i < npoints; ++i) {
    short x = buf.get();
    short y = buf.get();
}