JSONObject jObj = new JSONObject(result);
JSONObject response = jObj.getJSONObject("response");
//JSONObject jb = new JSONObject(response);
JSONArray jr = response.getJSONArray("Message");
for(int i=0;i<jr.length();i++)
{
JSONObject jb1 = jr.getJSONObject(i);
String question = jb1.getString("question");
Log.i(".......",question);
}