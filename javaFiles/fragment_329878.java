static long test() {
    long ctr = 0x5;
    for(long i=0; i<0x10000; i++) {
        Scalarization s = new Scalarization();
        ctr = s.foo(ctr);
        s = new Scalarization();
        ctr = s.foo(ctr);
    }
    return ctr;
}