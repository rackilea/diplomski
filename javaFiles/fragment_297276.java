public static boolean[] unpack (int n, int length) {
    boolean[] res = new boolean[length];
    for(int i = length-1; n != 0x00 && i >= 0; i--) {
        if((n&0x01) != 0x00) {
            res[i] = true;
        }
        n >>>= 0x01;
    }
    return res;
}