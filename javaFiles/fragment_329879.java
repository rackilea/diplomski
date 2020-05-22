static long limit = 0;

static long test() {
    long ctr = 0x5;
    long i = limit;
    limit += 0x10000;
    for(; i<limit; i++) { // In this form if scalarization happens is nondeterministic: if the condition is hit before profiling starts scalarization happens, else not.

        Scalarization s = new Scalarization();
        ctr = s.foo(ctr);
        if(i == 0xf9a0) s = new Scalarization();
        ctr = s.foo(ctr);
    }
    return ctr;
}