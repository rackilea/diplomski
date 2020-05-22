public static int readIntFromMaskedBytes(int data, int mask) {
    int result = 0;
    int shift = 0;
    while (mask != 0) {
        if (mask & 1) {
            result |= (data & 1) << shift++;
        }
        data >>>= 1;
        mask >>>= 1;
    }
}