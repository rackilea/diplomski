// Hashtable.java -- edited for conciseness
public synchronized V get(Object key) {
    int hash = key.hashCode();
    int index = (hash & 0x7FFFFFFF) % table.length;
    // ...
}