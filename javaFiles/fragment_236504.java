Set<Integer> s1 = new HashSet<Integer>();
s1.add(1); s1.add(4); s1.add(5); s1.add(3);

Set<String> s2 = new HashSet<String>();
s2.add("1"); s2.add("2"); s2.add("3");

// map the equivalences from one set into the other
Map<String, Integer> map = new HashMap<String, Integer>();
map.put("1", 1);
map.put("2", 2);
map.put("3", 3);

for (String s : s2) {
    // find "associated element"
    Integer n = map.get(s);
    if (s1.contains(n))
        s1.remove(n);
}