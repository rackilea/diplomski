ArrayList<String> list = new ArrayList<String>();
list.add("cat");
list.add("dog");
list.add("ant");

// Print the original list
System.out.println("Before sort: " + list);

// Sort the list and print
Collections.sort(list);
System.out.println("After sort: " + list);