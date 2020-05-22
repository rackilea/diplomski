ArrayList<JSONArray> listB = new ArrayList<JSONArray>(); 

  JSONObject array = loadJSONObject("array.json");
  JSONArray arrayData = array.getJSONArray("data");
  for(int i = 0 ; i < arrayData.size(); i++){
    JSONObject data = arrayData.getJSONObject(i);
    println("\t",data.getString("word"),"=",data.getJSONArray("synonyms"));

    listB.add(data.getJSONArray("synonyms"));
  }

  System.err.println(listB);