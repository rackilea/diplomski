Map<String, String> map = new HashMap<>();
map.put("a", "");
map.put("b", "");
map.put("c", "");

Set<String> set = new HashSet<> ();
set.add("a");
set.add("b");

map.keySet().removeAll(set);

System.out.println(map); //only contains "c"