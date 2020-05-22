private static final int EXCEPT_R_MASK = 0xFF00FFFF;
private static final int ONLY_R_MASK = ~EXCEPT_R_MASK;
private static final int EXCEPT_B_MASK = 0xFFFFFF00;
private static final int ONLY_B_MASK = ~EXCEPT_B_MASK;

private int getBufferedColor(final int pSourceColor) {
    int r = (pSourceColor & ONLY_R_MASK) >> 16;
    int b = pSourceColor & ONLY_B_MASK;
    return
      (pSourceColor & EXCEPT_R_MASK & EXCEPT_B_MASK) | (b << 16) | r;
}