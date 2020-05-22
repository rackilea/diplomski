JSONArray topologyInfo = new JSONArray();
String[] ids = {"1","2","3"};
JSONObject topoInfo = readTaskLog(); //returns an object like {Name:"Stack"}
if (topoInfo != null) {
    for (String id : ids) {
        JSONObject tempobj=new JSONObject(topoInfo.toString());
        tempobj.put("id", id));
        topologyInfo.put(tempobj);
    }
}