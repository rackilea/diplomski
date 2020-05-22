List<String> l1 = new ArrayList<>();
l1.add("Hello");
List<?> l2 = l1;
var l3 = l2; // type of 'l3' is List<?>, but not the same '?' as 'l2'

l3.add(l2.get(0)); // error