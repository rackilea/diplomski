CopyOnWriteArrayList<String> ll = new CopyOnWriteArrayList<String>(new String[10]);
ll.add(1, "1");
ll.add(0, "0");
System.out.println(ll); 

>>> [0, null, 1, null, null, null, null, null, null, null, null, null]