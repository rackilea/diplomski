TreeMap<Integer,String> map = new TreeMap<Integer,String>();
map.put(33, "Three");
map.put(44, "Four");
map.put(11, "One");
map.put(22, "Two");

int thirdKey = map.higherKey(map.higherKey(map.firstKey()));
System.out.println(thirdKey); // prints "33"