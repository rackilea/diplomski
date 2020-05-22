private static float[] getValuesAsArray(Map<Integer, DataStore> dataMap, ValueGetter func) {
    int i = 0;
    int nMap = dataMap.size();
    float[] fArray = new float[nMap];
    for (Map.Entry<Integer, DataStore> entry : dataMap.entrySet()) {
        DataStore ds = entry.getValue();
        fArray[i] = func.get(ds);
        i++;
    }
    return fArray;
}