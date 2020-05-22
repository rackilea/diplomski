JSONObject associative = loadJSONObject("associative.json");
  JSONObject associativeData = associative.getJSONObject("data"); 

  ArrayList<JSONArray> listA = new ArrayList<JSONArray>(); 

  for(Object key : associativeData.keys()){
    String keyName = (String)key;
    JSONArray data = associativeData.getJSONArray(keyName);
    println(keyName,"=",data);
    listA.add(data);
  }

  System.err.println(listA);