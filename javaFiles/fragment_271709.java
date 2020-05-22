static final int tableSizeFor(int cap) {
     int n = cap - 1;
     n |= n >>> 1;
     n |= n >>> 2;
     n |= n >>> 4;
     n |= n >>> 8;
     n |= n >>> 16;
     return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY: n + 1;
 }

public  [More ...] HashMap(int initialCapacity, float loadFactor) {
     ...
     this.loadFactor = loadFactor;
     this.threshold = tableSizeFor(initialCapacity);
}