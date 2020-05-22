HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
 int serialno = 0;

 for (int i = 1000; i < 1004; i++) {
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(i);
      temp.add((i + 1000));
      System.out.println(i + 1000);

      map.put(serialno++, temp);
 }
 System.out.println(map);