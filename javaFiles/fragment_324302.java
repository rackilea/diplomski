List<String> original = new ArrayList<>();
original.add("foo");
List<String> copy = new ArrayList<>(original);
System.out.println(copy.size()); // 1
original.add("bar");
System.out.println(copy.size()); // Still 1