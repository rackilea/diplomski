Runtime r = Runtime.getRuntime();
r.gc();
long f = r.freeMemory();
long m = r.maxMemory();
long t = r.totalMemory();
for (;;) {
    r.gc();
    long f2 = r.freeMemory();
    long m2 = r.maxMemory();
    long t2 = r.totalMemory();
    if (f == f2 && m == m2 && t == t2) 
        break;
    f = f2; 
    m = m2; 
    t = t2; 
}   
System.out.println("Full GC achieved.");