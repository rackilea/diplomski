JSONObject data = new JSONObject(your_JSON_Repsonse);
JSONArray data_desc=data.getJSONArray(desc);
for(int i=0;i<=data_desc.length();i++)
{
 name=data_desc.getString("name");
url=data_desc.getString("url");
color=data_desc.getString("color");
}