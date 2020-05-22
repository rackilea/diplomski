public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length); // get table/ bucket index
        for (Entry<K,V> e = table[i]; e != null; e = e.next) { // walk through the list of nodes
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;         // return old value if found
            }
        }

        modCount++;
        addEntry(hash, key, value, i); // add new value if not found
        return null;
    }