List<Map<String, Object>> resultMapList= new ArrayList<Map<String, Object>>();

      Map<String, List<Map<String, Integer>>>  listMap= new TreeMap<String, List<Map<String, Integer>>>();

      for(Map<String, Object> mapList:resultMapList){
          List< Map<String, Integer>> ListMapPair= new ArrayList<Map<String, Integer>>();
          Map<String, Integer> entry= new HashMap<String, Integer>();
      }

      Map<String, List<Object>> m= new HashMap<String, List<Object>>();

      List<Object> list= new ArrayList<Object>();
      list.add(1);
      list.add(2);
      list.add(3);
      m.put("a", list);

      List<Object> list1= new ArrayList<Object>();
      list1.add(4);
      list1.add(5);
      list1.add(6);
      m.put("b", list1);

      m.put("c", list);

      System.out.println(m);