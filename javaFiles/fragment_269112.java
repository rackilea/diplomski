public ArrayList<SortedMap<String, String>> sortMaps(Vector<HashMap<String, String> maps) {
    ArrayList<TreeMap<String, String>> returnMaps = new ArrayList<TreeMap<String, String>>();
    for(HashMap<String, String> theMap : maps) {
        // TreeMap is a sorted map and this will use the default String.compareTo
        TreeMap<String, String> newMap = new TreeMap<String, String>();
        // put all the items from the HashMap into the TreeMap, which will autosort
        newMap.putAll(theMap);
        returnMaps.add(newMap);
    }
    return returnMaps;
}