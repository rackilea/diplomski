ArrayList<Integer> list = new ArrayList<Integer>();
list.add(1);
list.add(2);
list.add(3);

Iterator<Integer> it = list.listIterator();

System.out.println("First Element : " + it.next());