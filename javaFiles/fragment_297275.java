public static boolean[] unpack (int n) {
    boolean[] res = new boolean[32];
    for(int i = 31; n != 0x00; i--) {
        if((n&0x01) != 0x00) {
            res[i] = true;
        }
        n >>>= 0x01;
    }
    return res;
}