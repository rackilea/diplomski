JSONObject jsonObj = new JSONObject(data);
JSONArray empInfo = jsonObj.getJSONArray("emp_info");
for(int i = 0; i < empInfo.length(); i++){
    JSONObject obj = empInfo.getJSONObject(i);
    String id = obj.getString("id");
    String groupe = obj.getString("groupe");
    String professeur = obj.getString("professeur");
}