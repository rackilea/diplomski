Multimap<Integer, Integer> map = HashMultimap.create();
map.put(300, 301);
map.put(300, 302);
map.put(300, 303);

Collection<Integer> list = map.get(300); // [301, 302, 303]