class SummingMap extends HashMap<Integer, Integer> {
    @Override
    public Integer put(Integer key, Integer value) {
        Integer oldResult = get(key);
        return super.put(key, value + (oldResult == null ? 0 : oldResult));
    }
}