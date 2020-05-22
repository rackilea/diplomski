private static byte[] shortToByteLittleEndian(final int[] samples, final int offset) {
    byte[] buf = new byte[2];
    int sample = samples[offset];
    buf[0] = sample & 0xFF;
    buf[1] = (sample >> 8) & 0xFF;
    return buf;
}