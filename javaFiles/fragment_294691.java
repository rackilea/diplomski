private final AtomicInteger[] a = new AtomicInteger[N];
...

public A(){
    for(int i = 0; i < N; i++)
       a[i] = new AtomicInteger(0);
}

public void m(int i) {
    a[i].incrementAndGet();
}