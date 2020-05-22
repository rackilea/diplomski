List<List<HashMap<String, String>>> childData = new ArrayList<List<HashMap<String, String>>>();
for(int i=0;i<6;i++)
    childData.add(new ArrayList<HashMap<String,String>>());
for (int i = 0; i < jArray.length(); i++) { 
    JSONObject jObj = jArray.getJSONObject(i);  

    HashMap<String, String> hm = new HashMap<String, String>();
    hm.put("moduleName", jObj.getString("moduleName"));
    hm.put("startTime",
            (jObj.getString("startTime")).substring(0, 5));
    hm.put("endTime",
            (jObj.getString("endTime")).substring(0, 5));
    hm.put("group", jObj.getString("group"));
    hm.put("roomName", jObj.getString("roomName"));
    hm.put("firstName", jObj.getString("firstName"));
    hm.put("lastName", jObj.getString("lastName"));

    childData.get(Integer.parseInt(jObj.getString("day"))).add(hm);
}