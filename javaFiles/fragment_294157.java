SortedMap<String, Double> myMap = new TreeMap<String, Double>();
    myMap.put("a", 10.0);
    myMap.put("b", 9.0);
    myMap.put("c", 11.0);
    myMap.put("d", 2.0);
    sortedset.addAll(myMap.entrySet());
    System.out.println(sortedset);