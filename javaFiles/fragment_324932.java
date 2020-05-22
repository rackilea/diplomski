JSONArray  jsonData = jObj.getJSONArray("allergens");
for(int i=0;i<jsonData.length();i++)
{
     JSONObject jb = (JSONObject) jsonData.get(i);
     String allergenname = jb.getString("allergen_name");  
}