public static void readWithBuffers() throws Exception {
    FileInputStream fis = new FileInputStream(FILE);
    FileChannel channel = fis.getChannel();
    CharsetDecoder decoder = Charset.defaultCharset().newDecoder();

    // CharsetDecoder decoder = Charset.forName("ISO-8859-1").newDecoder();

    ByteBuffer bbuf = ByteBuffer.allocate(4096);
    // ByteBuffer bbuf = ByteBuffer.allocateDirect(4096);
    CharBuffer cbuf = CharBuffer.allocate(4096);
    // CharBuffer cbuf = ByteBuffer.allocateDirect(2 * 4096).asCharBuffer();

    for(;;) {
        if(-1 == channel.read(bbuf)) {
            decoder.decode(bbuf, cbuf, true);
            decoder.flush(cbuf);
            break;
        }
        bbuf.flip();

        CoderResult res = decoder.decode(bbuf, cbuf, false);
        if(CoderResult.OVERFLOW == res) {
            cbuf.clear();
        } else if (CoderResult.UNDERFLOW == res) {
            bbuf.compact();
        }
    }

    fis.close();
}