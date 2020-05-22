List<String> list1 = new ArrayList<String>();
list1.add("Apple");
list1.add("Bus");
list1.add("Cat");
list1.add("Dog");
// retain a reference to the same list iterator
ListIterator<String> list1itr = list1.listIterator();
String ne = list1itr.next();
System.out.println(ne);
list1itr.remove();