class GetMaxEntry implements TObjectIntProcedure {
    Object key;
    int value = Integer.MIN_VALUE;
    public boolean execute(Object k, int v) {
        if (v >= value) {
            key = k;
            value = v;
        }
        return true;
    }
}
GetMaxEntry getMaxEntry = new GetMaxEntry();
map.forEachEntry(getMaxEntry);
//process(getMaxEntry.key, getMaxEntry.value);