java.util.concurrent.atomic.AtomicIntegerArray aia;

....

void remove(int i) {
    int j = i/32; //gets which array index to access
    do {
        int oldVal = aia.get(j);
        int newVal = oldVal & ~(1 << (i%32));
        boolean updated = aia.weakCompareAndSet(j, oldVal, newVal);
    } while(!updated);
}