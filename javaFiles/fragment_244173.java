Map<String, Multiset<String>> mapWithMultiset = new HashMap<>();
// create new multiset to be put as value
HashMultiset<String> x = HashMultiset.create();
x.add("X", 2);
mapWithMultiset.put("AS", x);

// this feels dirty
if (!mapWithMultiset.containsKey("AS")) {
  mapWithMultiset.put("AS", HashMultiset.<String>create());
}
mapWithMultiset.get("AS").add("BS", 123);

System.out.println(mapWithMultiset);
// prints: {AS=[BS x 123, X x 2]}