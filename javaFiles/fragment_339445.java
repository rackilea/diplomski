class WebStream extends FilterInputStream {

    byte[] buff = new byte[1024];
    int offset = 0, length = 0;

    public WebStream(InputStream i) {
        super(i);
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read() throws IOException {
        if (offset == length)
            readNextChunk();
        if (length == -1)
            return -1;// eof
        return buff[offset++];
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (offset == length)
            readNextChunk();
        if (length == -1)
            return -1;// eof

        int cop = length - offset;
        if (len < cop)
            cop = len;
        System.arraycopy(buff, offset, b, off, cop);
        offset += cop;
        return cop;
    }

    private void readNextChunk() throws IOException {
        if (offset <= length) {
            System.arraycopy(buff, offset, buff, 0, length - offset);
            length -= offset;
            offset = 0;
        }
        int read = in.read(buff, length, buff.length - length);
        if (read < 0 && length <= 0) {
            length = -1;
            offset = 0;
            return;
        }

        // note that this is assuming ascii compatible
        // anything like utf16 or utf32 will break here
        for (int i = length; i < read + length; i += 16) {
            if (buff[i] == 0x04) {
                while (buff[--i] == 0x04)
                    ;// find beginning of delim block
                length = i;
                read = 0;
            }
        }
    }

}