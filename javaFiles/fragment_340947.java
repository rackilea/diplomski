JSONArray jsonArrayMike = new JSONArray(jsonStringMike);

 int countMike = jsonArrayMike.length(); // get totalCount of all jsonObjects


  for (int i = 0; i < countMike; i++) {   // iterate through jsonArray 
        JSONObject jsonObject = jsonArrayMike.getJSONObject(i);  // get jsonObject @ i position 
        JSONArray movement = jsonObject.getJSONArray("movements");

        int o = movement.length();
    for (int p = 0; p < o; p++) 
    {
      JSONObject movementObject = movement.getJSONObject(p);
      JSONObject edgeObject = movementObject.getJSONObject("edge");

      JSONObject fromNode = edgeObject.getJSONObject("fromNode");
      String latitude = fromNode.getString("latitude");
      String longitude = fromNode.getString("longitude");
      String nodeId = fromNode.getString("nodeId");
      System.out.println(fromNode);
    }
  }