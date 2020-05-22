LinkedList<Integer> list1 = new LinkedList<Integer>();
list1.add(1);
list1.add(2);
LinkedList<Integer> list2 = new LinkedList<Integer>();
list2.add(3);
list2.add(4);
list1.addAll(list2); // now list1 has elements [1, 2, 3, 4]