Map<Integer, Map<String, Object>> original=new HashMap<Integer, Map<String,Object>>();
Map<Integer, Map<String, Object>> copy = 
        new HashMap<Integer, Map<String, Object>>();
for(Entry<Integer, Map<String, Object>> entry : original.entrySet()){
    copy.put(entry.getKey(), new HashMap<String, Object>(entry.getValue()));
}