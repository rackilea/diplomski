long t0 = System.currentTimeMillis();
// do something
long t1 = System.currentTimeMillis();
if (t1-t0 > x*1000) {
    return;
}