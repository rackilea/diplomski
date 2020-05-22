Map<String,Integer> map = new TreeMap<String,Integer>();
    map.put("A", 3);
    map.put("B", 2);
    map.put("C", 1);   

    System.out.println(map);
    // prints "{A=3, B=2, C=1}"
    System.out.println(entriesSortedByValues(map));
    // prints "[C=1, B=2, A=3]"