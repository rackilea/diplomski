Map<String, Double> map3= new LinkedHashMap<String, Double>();
for(String key : map1.keySet()) {
    if(map2.containsKey(key)) {
       map3.put(key, map1.get(key) * map2.get(key);
    }
}