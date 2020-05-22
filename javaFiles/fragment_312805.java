ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
arrayLists.add(new ArrayList<Integer>());
arrayLists.get(0).add(100);
arrayLists.get(0).add(50);

arrayLists.add(new ArrayList<Integer>());
arrayLists.get(1).add(67);

System.out.println(arrayLists.get(0).get(0));   // 100
System.out.println(arrayLists.get(0).get(1));   //  50
System.out.println(arrayLists.get(1).get(0));   //  67