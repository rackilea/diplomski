SortedMap map = new SortedMap();

map.put(1, "top1");
map.put(2, "bottom1");
map.put(3, "top2");
...
...
...
Iterator iterator = map.keySet().iterator();
while (iterator.hasNext()) {
   Object key = iterator.next();
   System.out.println(" card :" + map.get(key));
}