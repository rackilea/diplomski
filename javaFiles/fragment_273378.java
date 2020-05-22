Map<String, Double> map = new LinkedHashMap<>();
    map.put("one", 2.0);
    map.put("two", 12.0);
    map.put("three", 44.0);
    String lKeyFirst = null;
    String lKeyLast = null;
    if (!map.isEmpty()){
      lKeyFirst = map.keySet().iterator().next();
      for(String key : map.keySet()){
        lKeyLast = key;
      }
      System.out.println("First key: " +lKeyFirst);
      System.out.println("Last key: " +lKeyLast);
    }