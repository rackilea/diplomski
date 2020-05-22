TreeMap<Long,Object> map = new TreeMap<Long,Object>();
Long key = 42;
Map.Entry<Long,Object> low = map.floorEntry(key);
Map.Entry<Long,Object> high = map.ceilingEntry(key);
Object res = null;
if (low != null && high != null) {
    res = Math.abs(key-low.getKey()) < Math.abs(key-high.getKey())
    ?   low.getValue()
    :   high.getValue();
} else if (low != null || high != null) {
    res = low != null ? low.getValue() : high.getValue();
}