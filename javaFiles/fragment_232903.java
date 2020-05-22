public Map<Integer, String> findFaildStudent(Map<Integer, String>map1,Map<Integer, String>map2){
Map<Integer, String> failed = new HashMap<>();

for (Map.Entry<Integer, String> k : map2.entrySet()) {
    if(k.getValue().equals("fail")){
        failed.put(k.getKey(), map1.get(k.getKey()));
    }
}
return failed;
//returns... (1,"x"), (2, "y"), (3, "z")