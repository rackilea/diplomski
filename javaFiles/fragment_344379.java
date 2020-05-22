public Object put(Object key, Object value) {
    // Make sure the value is not null
    if (value == null) throw new NullPointerException();

    // Makes sure the key is not already in the hashtable.
    HashtableEntry e;
    HashtableEntry tab[] = table;
    int hash = key.hashCode();
    int index = (hash & 0x7FFFFFFF) % tab.length;

    for (e = tab[index] ; e != null ; e = e.next) {
        if ((e.hash == hash) && e.key.equals(key)) {
        Object old = e.value;
        e.value = value;
        return old;
        }
    }