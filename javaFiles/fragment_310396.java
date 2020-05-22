ArrayList<Integer> list2 = new ArrayList<Integer>();
list2.add(100);
list2.add(200);

// This assignment is OK:
ArrayList<? extends Number> list3 = list2;   
Number n = list3.get(0); // n is now 100