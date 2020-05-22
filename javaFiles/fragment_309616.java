List<String> list = new ArrayList<String>();
list.add("A");
list.add("B");
list.add("C");

// Obtain the subList
List<String> subList = list.subList(1,2);

// Modify the backing list
list.add("X");

// Try to modify the subList: Causes ConcurrentModificationException
subList.add("Y");