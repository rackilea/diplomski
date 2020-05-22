class HexInputStream extends FilterInputStream {

    HexInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] buff, int off, int len) throws IOException {
        int b = super.read();
        String hex = String.format("%02x", b);
        buff[0 + off] = (byte)hex.charAt(0);
        buff[1 + off] = (byte)hex.charAt(1);
        return 2;
    }
}