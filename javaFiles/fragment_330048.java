Map<Bar, Bar> map = // LinkedHashMap or ConcurrentHashMap

Bar bar1 = new Bar(1);
map.put(bar1, bar1);

Bar bar1a = map.get(new Bar(1));