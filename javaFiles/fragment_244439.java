public void processJSON(Object obj){
    JSONObject jsonObj = null;
    JSONArray jsonArr = null;
    jsonObj = objectToJSONObject(obj);
    jsonArr = objectToJSONArray(obj);
    if (jsonObj != null) {
        //process JSONObject
    } else if (jsonArr != null) {
        //process JSONArray
    }
}