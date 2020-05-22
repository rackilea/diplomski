// we iterate over all arrays of Map
for (Map<String,Object> map : raw_attributes){
    // we iterate over all values of the current map
    for (Entry<String,Object> entry  : map.entrySet()){            
      String key = entry.getKey();
      Object value = entry.getValue();
    }

}