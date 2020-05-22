public static short[] shortMe(byte[] bytes) {
    short[] out = new short[bytes.length / 2]; // will drop last byte if odd number
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    for (int i = 0; i < out.length; i++) {
        out[i] = bb.getShort();
    }
    return out;
}