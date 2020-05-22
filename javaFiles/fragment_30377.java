public V put(K key, V value) {
    Entry<K,V> t = root;
    if (t == null) {
        // TBD:
        // 5045147: (coll) Adding null to an empty TreeSet should
        // throw NullPointerException
        //
        // compare(key, key); // type check
        root = new Entry<K,V>(key, value, null);
        size = 1;
        modCount++;
        return null;
    }
    ...