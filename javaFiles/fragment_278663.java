Map<String, String> map = new HashMap<String, String>();
map.put("1", "one");
map.put("2", "two");
map.put("3", "three");

Set<String> set = new HashSet<String>();
set.add("1");
set.add("3");

map.keySet().retainAll(set);

System.out.println(map); // {3=three, 1=one}