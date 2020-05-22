ArrayList<Integer> list = new ArrayList<Integer>(); 

list.add(1);
list.add(2);
list.add(3);

list.set(0, list.get(list.size() - 1));
list.remove(list.size() - 1);

System.out.println(list);