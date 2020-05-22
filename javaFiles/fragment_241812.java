NavigableMap<Integer, Integer> map = new TreeMap<>();
map.put(1, 10);
map.put(0, -10);
map.put(5, 25);
map.put(3, 20);

// find the value below.
int key = 2;
Map.Entry<Integer, Integer> entry1 = map.floorEntry(key);
Map.Entry<Integer, Integer> entry2 = map.ceilingEntry(key);
System.out.println(key + " is between " + entry1 + " and " + entry2);