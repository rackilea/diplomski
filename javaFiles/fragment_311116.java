private static double bin5(byte[] b, int k) {
    int b0 = b[k] & 0xFF;     // treat as unsigned byte
    int b1 = b[k + 1] & 0xFF;
    int b2 = b[k + 2] & 0xFF;
    int b3 = b[k + 3] & 0xFF;
    int b4 = b[k + 4] & 0xFF;
    return (b0 * 65536 + b1 * 256 + b2 + b3 / 256.0 + b4 / 65536.0);
}