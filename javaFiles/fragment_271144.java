TreeMap<ItemList,Object> tm=new TreeMap<>();
tm.put(ItemList1.Apple, "A");
tm.put(ItemList1.Orange, "O");
System.out.println(tm.get(ItemList1.Apple)+" is for "+ItemList1.Apple);
tm.clear();
tm.put(ItemList2.Banana, "B");
tm.put(ItemList2.Grapes, "G");
System.out.println(tm.get(ItemList2.Banana)+" is for "+ItemList2.Banana);