/**
     * Removes this entry from the linked list.
     */
    private void remove() {
        before.after = after;
        after.before = before;
    }

    /**
     * Inserts this entry before the specified existing entry in the list.
     */
    private void addBefore(Entry<K,V> existingEntry) {
        after  = existingEntry;
        before = existingEntry.before;
        before.after = this;
        after.before = this;
    }

    /**
     * This method is invoked by the superclass whenever the value
     * of a pre-existing entry is read by Map.get or modified by Map.set.
     * If the enclosing Map is access-ordered, it moves the entry
     * to the end of the list; otherwise, it does nothing.
     */
    void recordAccess(HashMap<K,V> m) {
        LinkedHashMap<K,V> lm = (LinkedHashMap<K,V>)m;
        if (lm.accessOrder) {
            lm.modCount++;
            remove();
            addBefore(lm.header);
        }