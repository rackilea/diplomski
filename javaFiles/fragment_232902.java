public Map<String, String> findFaildStudent(Map<Integer, String>map1,Map<Integer, String>map2){
    Map<String, String> failed = new HashMap<>();

    for (Map.Entry<Integer, String> k : map2.entrySet()) {
        if(k.getValue().equals("fail")){
            failed.put(map1.get(k.getKey()), map2.get(k.getValue()));
        }
    }
    return failed;
 }
//returns... ("x","failed"), ("y", "failed"), ("z", "failed")