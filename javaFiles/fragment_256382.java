TreeMap<Integer, Range> map = new TreeMap<>();
    map.put(1, new Range(1, 10));
    map.put(11, new Range(11, 30));
    map.put(31, new Range(31, 100));

    // int key = 0; // null
    // int key = 1; // Range [start=1, end=10]
    // int key = 11; // Range [start=11, end=30]
    // int key = 21; // Range [start=11, end=30]
    // int key = 31; // Range [start=31, end=100]
    // int key = 41; // Range [start=31, end=100]
    int key = 101; // Range [start=31, end=100]
    // etc.

    Range r = null;
    Map.Entry<Integer, Range> m = map.floorEntry(key);
    if (m != null) {
        r = m.getValue();
    }
    System.out.println(r);