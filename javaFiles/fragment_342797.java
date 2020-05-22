TreeMap<String, TreeSet<String>> treeMap = null;
// First you instantiate your TreeMap
treeMap = new TreeMap<String, TreeSet<String>>();

// Next you create your TreeSet value which you can instantiate with your comparator
TreeSet<String> value = new TreeSet<String>(myComparator);
value.add("FOO");
value.add("BAR");
// Then you can insert that TreeSet as value in your TreeMap
treeMap.put("your-string-key", value);