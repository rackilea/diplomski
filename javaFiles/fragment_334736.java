Map<String, String> map = new LinkedHashMap<String,String>();

    map.put("one", "value 1");
    map.put("two", "value 2");
    map.put("three", "value 3");

    for (Map.Entry<String,String> entry : map.entrySet()){

      if (entry.getKey().equals("two")){

        System.out.println(entry.getValue());

      }

    }