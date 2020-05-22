// Remove the spacings yourself before trying the code
JSONArray array = new JSONArray("[
   {
      "downloadUrl":"URL",
      "fileName":"Name",
      "gameVersion":"Version",
      "name":"Name",
      "projectId":ID,
      "releaseType":"beta"
   },
   {
      "downloadUrl":"URL",
      "fileName":"Name",
      "gameVersion":"Version",
      "name":"Name",
      "projectId":ID,
      "releaseType":"beta"
   }
]");

List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>();
for(int i = 0 ; i < array.length() ; i++){
    HashMap<String,String> ht = new HashMap<String,String>();
    JSONObject o = json.getJSONObject(i);
    map.put("downloadUrl",o.getString("downloadUrl");
    map.put("fileName",o.getString("fileName");
    map.put("gameVersion",o.getString("gameVersion");
    map.put("name",o.getString("Name"));
    map.put("projectId",o.getString("projectId");
    map.put("releaseType",o.getString("releaseType");
    list.add(map);
}