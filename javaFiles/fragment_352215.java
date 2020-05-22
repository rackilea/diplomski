public Collection<V> values() {
    Collection<V> vs = values;
    if (vs == null) {
        values = new Values();
        return values;
    } else {
        return vs;
    }
}