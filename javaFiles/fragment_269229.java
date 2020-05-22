Multimap<Integer, String> myMultimap = ArrayListMultimap.create();

myMultimap.put(1,"student1");
myMultimap.put(1,"student2");

Collection<String> values = myMultimap.get(1);