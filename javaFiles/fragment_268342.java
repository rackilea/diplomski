class LimitedTreeMap<Long, V> extends TreeMap<Long, V> {

    int limitSize;

    public LimitedTreeMap(int limitSize) {
        this.limitSize = limitSize;
    }

    @Override
    public V put(Long key, V value) {

        // Add logic for the desired behaviour
        V v = super.put(key, value);

        if (this.size() > limitSize)
            this.pollFirstEntry();

        return v;

    }

}