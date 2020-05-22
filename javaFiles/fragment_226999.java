int[] convertFive(byte a, byte b, byte c, byte d, byte e) {
    int p = ((a & 0xff) << 2) | (b & 0xc0) >>> 6;
    int q = ((b & 0x3f) << 4) | (c & 0xf0) >>> 4;
    int r = ((c & 0x0f) << 6) | (d & 0xfc) >>> 2;
    int s = ((d & 0x03) << 8) | (e & 0xff) >>> 0;
    return new int [] { p, q, r, s }; 
}