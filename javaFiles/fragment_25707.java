JSONArray ja = new JSONArray();
for (Dependency dependency : dependencyList) {
   .....
   JSONObject obj=new JSONObject();
   obj.put("name",dependency.getArtifactId()); 
   obj.put("Version",version);
   ja.put(obj);
   //remove dependencies.put,JSONArray. and genarateTechnologyRadarJson(jsonArray);
}
writer.write(ja.toString());