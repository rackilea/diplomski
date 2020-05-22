List<String> aList = new ArrayList<String>();
aList.add("a");
aList.add("b");
aList.add("c");
aList.add("d");
aList.add("e");

List<String> bList = new ArrayList<String>();
bList.add("b");
bList.add("e");
bList.add("d");

aList.removeAll(bList);