byte[] b = toBytes(new int[]{0x00, 0x7F, 0x80, 0xFF});

static byte[] toBytes(int[] x) {
    byte[] y = new byte[x.length];
    for (int i = 0; i < x.length; i++)
        y[i] = (byte)x[i];
    return y;
}