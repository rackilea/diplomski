ArrayList<ArrayList<String>> aList1 = new ArrayList<>();
   ArrayList<String> aList2 = new ArrayList<>();
   aList2.add("Object 1");
   aList2.add("Object 2");
   aList1.add(new ArrayList(aList2));
   aList2.clear();
   System.out.println(aList1);