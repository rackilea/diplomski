List<JSONObject> result = new ArrayList<JSONObject>();
String s = "{Valid JSON String},{Valid JSON String},{Valid JSON String}";
JSONArray arr = new JSONArray("[" + s + "]");
for (int i = 0; i < arr.length(); i++)
{
    result.add(arr.getJSONObject(i));
}