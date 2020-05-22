String arr[] ={"lady", "bird", "is","bird","lady","cook"};
    Map<String, Integer> map = new HashMap<>();
    for(String str: arr) {
        if(map.containsKey(str)) {
            map.put(str, map.get(str)+1);
        } else{
            map.put(str, 1);
        }
    }
    for(String str: map.keySet()) {
        if(map.get(str) > 1) {
            System.out.println("Duplicate: "+ str+" count:"+map.get(str));
        }
    }