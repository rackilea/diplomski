int input = 5;
   List<Double> origList = new ArrayList<Double>();

   origList.add(-6789.44658);
   origList.add(-27239.73827);
   origList.add(-12365.78370);
   origList.add(-456.789457);
   origList.add(-4768.42579);
   origList.add(-15263.26399);
   origList.add(-15263.26399);
   origList.add(-0.0);
   origList.add(-24688.7289);

   TreeMap<Double, List<Integer>> smallest = new TreeMap<Double, List<Integer>>();
   for (int i = 0; i < origList.size(); i++) {
       double d = origList.get(i);
       List<Integer> list = smallest.get(d);
       if (list == null) {
           list = new ArrayList<Integer>();
           smallest.put(d, list);
       }
       list.add(i);
   }