Gson gson = new Gson();
  if(isArray){
     myJsonObjects  jsonArray = gson.fromJson(jsonStringFromFile,myJsonObjects );

  }
  else{
   gson.fromJson(jsonStringFromFile,JsonObject);
  }