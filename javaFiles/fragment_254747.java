aList.add("1");
aList.add("2");
aList.add("3");
aList.add("4");
aList.add("5");

ListIterator listIterator = aList.listIterator();

System.out.println("moving forward");
while(listIterator.hasNext()) {
  System.out.println(listIterator.next());
}

System.out.println("moving backward");
while(listIterator.hasPrevious()) {
  System.out.println(listIterator.previous());
}