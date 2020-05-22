HashMap<String, Object> hashMap = new HashMap<String, Object>();
    hashMap.put("123", "xyz");
    HashMap<Integer, Object> map = new HashMap<Integer, Object>();
    map.put(453, hashMap);
    HashMap<String, Object> newMap = (HashMap<String, Object>) map.get(453);

    System.out.println("Main map "+ hashMap);
    System.out.println("Map inside map "+map);
    System.out.println("Extracted map "+newMap);