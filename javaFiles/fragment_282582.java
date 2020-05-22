/**
 * Returns the first Entry in the TreeMap (according to the TreeMap's
 * key-sort function).  Returns null if the TreeMap is empty.
 */
final Entry<K,V> getFirstEntry() {
    Entry<K,V> p = root;
    if (p != null)
        while (p.left != null)
            p = p.left;
    return p;
}