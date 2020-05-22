Map<T, Integer> freq = new HashMap<T, Integer> () {
    @Override
    public Integer get(Object key) {
        return containsKey(key) ? super.get(key) : 0;
    }
}