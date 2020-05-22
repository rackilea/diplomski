ListIterator<String> list = nameList.listIterator(nameList.size());

// Iterate in reverse.
while(list.hasPrevious()) {
  System.out.println(list.previous());
}