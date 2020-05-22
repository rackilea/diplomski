public static long fact(int n) {
    long rs = 1;
    if( n <2) return 1;
    for (int i=2; i<=n; i++) {
        rs *=i;
        System.out.println(rs);
    }
    return rs;
}