public long[] removeElement(long[] in, int pos) {
    if (pos < 0 || pos >= in.length) {
        throw new ArrayIndexOutOfBoundsException(pos);
    }
    long[] res = new long[in.length - 1];
    System.arraycopy(in, 0, res, 0, pos);
    if (pos < in.length - 1) {
        System.arraycopy(in, pos + 1, res, pos, in.length - pos - 1);
    }
    return res;
}