class ImmutableMap<K, V> implements Map<K, V> {
    private Map<K, V> map;

    public ImmutableMap(Map<K, V> map) {
        this.map = new HashMap<>(map); // detach reference
    }

    //implement methods from Map
}