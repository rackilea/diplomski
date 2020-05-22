String json="Your Json";
JSONObject resultJson = new JSONObject(json);
JSONArray value = resultJson.getJSONArray(<Pass Your JsonOject Key here>);
ArrayList<String> list = new ArrayList<>();

for (int i = 0; i < value.length(); i++)
{
    JSONObject qstnArray = value.getJSONObject(i);
    list.add(qstnArray.getString("question"));                  
}