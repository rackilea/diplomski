JSONArray array =new JSONArray(); 
 for (String key : map.keySet()) { 
      JSONObject json = new JSONObject(); 
      json.put("name", key);      
      json.put("T" + level, processList(map.get(key), level + 1)); 
      array.put(json); 
 } 
 return array;