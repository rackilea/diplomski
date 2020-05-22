JSONObject rootJsonObject = new JSONObject(json);
Iterator iterator = rootJsonObject.keys();
   while(iterator.hasNext()){
    //this below key will be the names of your each theater, you may 
    //add it into a list to populate spinner
    String key = (String)iterator.next();
    JsonArray theaterArray = rootJsonObject.getJsonArray(key);
    }