for (Object obj : jObj) {
    if (obj instanceof JSONObject){
        //do something
    }
    else if (obj instanceof JSONArray){
      continue;//skip
    }
}