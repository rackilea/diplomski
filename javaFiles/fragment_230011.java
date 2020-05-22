final ListMultimap<String,String> multimap = LinkedListMultimap.create();
// put values from question here

final List<Object> firstValues = Lists.newArrayList();
for (final String key: multimap.keySet()) {
  firstValues.add(multimap.get(key).get(0));
}    
System.out.println(firstValues);
// prints [value1, value11, value111]
// similar for multimap.get(key).get(1) and so on