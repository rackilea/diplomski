synchronized (synchronizedMap) {
    // test for a key in the map
    if (synchronizedMap.containsKey(key)) {
      synchronizedMap.get(key).add(value);
    } else {
      List<String> valuesList = new ArrayList<String>();
      valuesList.add(value);
      // store a value into the map
      synchronizedMap.put(key, valuesList);
   }
}