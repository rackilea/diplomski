Set<Object> set = new HashSet<>();
List<Object> list = new ArrayList<>();
p1.test(set);
p2.test(list);
p1.test(list);
p2.test(set);