MultisetMultimap<String, String> multisetMultimap = HashMultisetMultimap.create();
multisetMultimap.add("AS", "X", 2);
multisetMultimap.add("AS", "BS", 123);

System.out.println(mapWithMultiset);
// should print: {AS=[BS x 123, X x 2]}