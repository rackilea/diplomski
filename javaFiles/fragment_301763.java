Map<String, String> m0 = new HashMap<String, String>();
m0.put("a", "a");
m0.put("b", "b");
Map<String, String> m1 = new HashMap<String, String>();
m1.put("c", "c");
m1.put("b", "b");
Set<String> s = new HashSet<String>(m0.keySet());
s.retainAll(m1.keySet());
System.out.println(s);