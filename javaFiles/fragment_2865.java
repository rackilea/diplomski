private static int[] MASKS = new int[31];
static {
    MASKS[0] = 1;
    for (int i = 1; i < MASKS.length; i++)
        MASKS[i] = (MASKS[i - 1] << 1) + 1;
}