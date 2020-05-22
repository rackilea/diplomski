List<String> list1 = new ArrayList<String>();
list1.add("foo");
list1.add("bar");

List<String> sameList = list1;
sameList.add("quux");

list1.clear();