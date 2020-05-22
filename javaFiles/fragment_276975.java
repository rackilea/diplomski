Map<String,String> initialMap = ...
Map<String,String> inverseMap = new HashMap<String,String>();
for (Map.Entry<String,String> entry: initialMap.entrySet()) {
    for (String v : entry.getValue().split(",")) {
        if (inverseMap.containsKey(v)) 
          inverseMap.put(v,inverseMap.get(v)+","+entry.getKey());
        else
          inverseMap.put(v, entry.getKey());
    }
}