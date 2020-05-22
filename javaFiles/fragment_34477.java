List<String> l1 = new ArrayList<>();
l1.add("Hello");
List<?> l2 = l1;

var x = l2.get(0);
l2.add(x); // error