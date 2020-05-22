public static int pack (boolean[] values) {
    int n = 0;
    for(int i = 0; i < values.length; i++) {
        n <<= 0x01;
        if(values[i]) {
            n |= 0x01;
        }
    }
    return n;
}