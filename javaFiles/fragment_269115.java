public SortedMap<String, String> singledSortedMap(Vector<HashMap<String, String> maps) {
    // this will end up with all the values, sorted by natural string ordering
    SortedMap<String, String> returnMap = new TreeMap<String, String>();
    for(HashMap<String, String> theMap : maps) {
        returnMap.putAll(theMap);
    }
    return returnMap;
}