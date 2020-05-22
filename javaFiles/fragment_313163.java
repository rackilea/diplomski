for(int i=0; i<usersInput; i++) {
    r = Random.new();
    [for(int j=0; j<100; j++) {
        r.rand();
    }] fork
}