Set<String> keys = map.keySet();
List<String> list = new ArrayList<>(keys); // 1
list.sort();

Collections.addAll(list, keys); // or 2
Collections.sort(list); 

SortedSet<String> set = new TreeSet<>(keys);