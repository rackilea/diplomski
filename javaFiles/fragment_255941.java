synchronized (synchronizedMap) {
    // test for a key in the map
    List<String> valuesList = synchronizedMap.get(key);
    if (valueList == null) {
      valuesList = new ArrayList<String>();
      // store a value into the map
      synchronizedMap.put(key, valuesList);
    }
    valuesList.add(value);
}