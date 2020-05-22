@SuppressWarnings("unchecked")
    public void put(K key, V value){
        if (this.containsKey(key)) {
            TableEntry<K, V> foundKey = this.getTableEntry(key);
            foundKey.setValue(value);
        } else {
            int slotNumber = Math.abs(key.hashCode()) % size;
            TableEntry<K,V> candidate = (TableEntry<K, V>) elements[slotNumber];

            // empty slot
            if (candidate == null) {
                elements[slotNumber] = new TableEntry<K, V>(key, value, null);
            } else {
                while (candidate != null) {
                    candidate = candidate.next;
                }
                candidate.next = new TableEntry<K, V>(key, value, null);
            }
        }
    }