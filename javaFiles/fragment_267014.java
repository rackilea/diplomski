public int pack(int v1, int v2, int v3) {
    return (v3 & 0x3f) <<  0 |
           (v2 & 0x3f) <<  6 |
           (v1 & 0x3f) << 12;
}

public void unpack(int n) {
    int v3 = (n >>  0) & 0x3f;
    int v2 = (n >>  6) & 0x3f;
    int v1 = (n >> 12) & 0x3f;
    // do stuff with v1, v2, v3
}