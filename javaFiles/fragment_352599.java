List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
    for(int i=0;i<5;i++) {          
        Map<String, Integer> map  = new HashMap<String, Integer>();
        map.put("test", i);
        list.add(map);
    }