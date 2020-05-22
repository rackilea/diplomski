String jsonString = <your jsonString>;

// THIS IS NOT NEEDED ANYMORE 
//JSONObject json = new JSONObject(jsonString);

JSONArray topArray = null; 
try {
     // Getting your top array

     // THIS IS NOT NEEDED ANYMORE 
     //topArray = json.getJSONArray(jsonString);

     //use this instead
     topArray = new JSONArray(jsonString);

      // looping through All elements
      for(int i = 0; i < topArray.length(); i++){
      JSONObject c = topArray.getJSONObject(i);

      //list holding row data
      List<NodePOJO> nodeList = new ArrayList<NodePOJO>(); 

      // Storing each json item in variable
      String nodeName = c.getString("nodeName");
      String nodeID = c.getString("nodeID");

      NodePOJO pojo = new NodePOJO();
      pojo.setNodeName(nodeName);
      //add rest of the json data to NodePOJO class

      //the object to list
      nodeList.add(pojo);

    }
} catch (JSONException e) {
        e.printStackTrace();
 }