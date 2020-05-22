public class BitReader {
    private static final int[] MASK = new int[16];
    static {
        for (int i = 0; i < 16; i++) {
            MASK[i] = (1 << i) - 1;
        }
    }

    private InputStream in;

    private int bitsLeft;

    private int bitBuffer;

    public BitReader(InputStream in) {
        this.in = in;
    }

    /**
     * Reads at most 8 bits from the InputStream.
     * 
     * @param bits
     *            between 1 and 8 (inclusive)
     */
    public int readBits(int bits) throws IOException {
        if (bits < 1 && bits > 8)
            throw new IllegalArgumentException("bits");
        if (bits > bitsLeft) {
            int r = in.read();
            if (r == -1) {
                throw new EOFException();
            }
            bitsLeft += 8;
            bitBuffer = (bitBuffer << 8) | r;
        }
        int result = bitBuffer >> (bitsLeft - bits);
        bitsLeft -= bits;
        bitBuffer &= MASK[bitsLeft];
        return result;
    }

    public int readBits17() throws IOException {
        return readBits(8) << 9 | readBits(8) << 1 | readBits(1);
    }
}