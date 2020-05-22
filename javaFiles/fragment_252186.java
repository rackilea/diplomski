private Map<Integer, List<Integer>> myMap = new HashMap<Integer, List<Integer>>();

   public void addItem(int key, int value) {
      List<Integer> list = myMap.get(key);
      if (list == null) {
         list = new ArrayList<Integer>();
         myMap.put(key, list);
      }
      list.add(value);
   }

   public List<Integer> getItems(int key) {
      return myMap.get(key);
   }